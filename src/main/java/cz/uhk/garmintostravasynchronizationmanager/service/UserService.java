package cz.uhk.garmintostravasynchronizationmanager.service;

import cz.uhk.garmintostravasynchronizationmanager.errorhandling.exceptions.InternalErrorException;
import cz.uhk.garmintostravasynchronizationmanager.errorhandling.exceptions.ItemNotFoundException;
import cz.uhk.garmintostravasynchronizationmanager.constants.ApiConstants;
import cz.uhk.garmintostravasynchronizationmanager.dao.AthleteDao;
import cz.uhk.garmintostravasynchronizationmanager.model.AthleteAuthorizationResponse;
import cz.uhk.garmintostravasynchronizationmanager.model.UserAthlete;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final AthleteDao athleteDao;
    private final StravaService stravaService;
    private final Environment env;

    @Autowired
    public UserService(AthleteDao athleteDao, StravaService stravaService, Environment env){
        this.athleteDao = athleteDao;
        this.stravaService = stravaService;
        this.env = env;
    }

    private void putAthlete(UserAthlete userAthlete) {
        athleteDao.save(userAthlete);
    }

    public UserAthlete initAuth(String code) {
        try {
            AthleteAuthorizationResponse athleteAuthorizationResponse = stravaService.authorize(code).get();
            UserAthlete userAthlete = athleteResponseToUserAthlete(athleteAuthorizationResponse);

            putAthlete(userAthlete);

            return userAthlete;
        } catch (Exception e) {
            throw new InternalErrorException("Error while getting athlete's data.");
        }
    }

    public UserAthlete getUser(String userToken) {
        final UserAthlete userAthlete = athleteDao.findByUserToken(userToken);

        if (userAthlete == null) {
            throw new ItemNotFoundException("User was not found.");
        } else {
            return userAthlete;
        }
    }

    private UserAthlete athleteResponseToUserAthlete(AthleteAuthorizationResponse athleteResponse){
        return new UserAthlete(
                athleteResponse.getAthlete().getId(),
                athleteResponse.getAthlete().getUsername(),
                athleteResponse.getAthlete().getFirstname(),
                athleteResponse.getAthlete().getLastname(),
                athleteResponse.getAthlete().getProfile_medium(),
                new ArrayList<>(), //TODO: dodělat napojení
                athleteResponse.getToken(),
                athleteResponse.getRefreshToken(),
                getJwtToken(athleteResponse)
        );
    }

    private String getJwtToken(AthleteAuthorizationResponse athleteResponse) {

        String key = env.getProperty(ApiConstants.JWT_TOKEN);
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        return Jwts
                .builder()
                .setId(athleteResponse.getAthlete().getId())
                .setSubject(athleteResponse.getAthlete().getUsername())
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + ApiConstants.EXPIRATION_TIME))
                .signWith(signingKey, SignatureAlgorithm.HS256).compact();
    }
}
