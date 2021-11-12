package cz.uhk.garmintostravasynchronizationmanager.service;

import cz.uhk.garmintostravasynchronizationmanager.dao.AthleteDao;
import cz.uhk.garmintostravasynchronizationmanager.model.UserAthlete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    private final AthleteDao athleteDao;
    private final StravaService stravaService;

    @Autowired
    public UserService(AthleteDao athleteDao, StravaService stravaService){
        this.athleteDao = athleteDao;
        this.stravaService = stravaService;
    }

    private void putAthlete(UserAthlete userAthlete) {
        athleteDao.save(userAthlete);
    }

    public Optional<UserAthlete> initAuth(String code){
        AthleteResponse athleteResponse = stravaService.getAthlete(code);
        UserAthlete userAthlete = athleteResponseToUserAthlete(athleteResponse.getStravaAthlete);
        
        putAthlete(userAthlete);

        return Optional.of(userAthlete);
    }

    public UserAthlete getUser(String userToken){
        return athleteDao.findByUserToken(userToken);
    }

    private UserAthlete athleteResponseToUserAthlete(AthleteResponse athleteResponse){
        UserAthlete userAthlete = new UserAthlete(athleteResponse.getStravaAthlete.getId(),
                athleteResponse.getStravaAthlete.getFirstName(),
                athleteResponse.getStravaAthlete.getLastName(),
                athleteResponse.getStravaAthlete.getProfilePicture(),
                athleteResponse.getStravaAuthorizationToken(),
                athleteResponse.getStravaRefreshToken(),
                getUserToken()
        );
        return userAthlete;
    }

    private String getUserToken(){
        //TODO
        Random rand = new Random();
        int random = rand.nextInt(10000);
        return Integer.toString(random);
    }
}
