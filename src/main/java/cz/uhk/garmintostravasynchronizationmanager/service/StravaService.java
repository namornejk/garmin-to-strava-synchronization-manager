package cz.uhk.garmintostravasynchronizationmanager.service;

import cz.uhk.garmintostravasynchronizationmanager.dao.IAthleteDao;
import cz.uhk.garmintostravasynchronizationmanager.model.AthleteResponse;
import cz.uhk.garmintostravasynchronizationmanager.model.AuthorizationRequest;
import cz.uhk.garmintostravasynchronizationmanager.model.AuthorizationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Optional;

@Service
public class StravaService {

    protected String BASE_URL = "https://www.strava.com/api/v3";

    private static final String ATHLETE = "/athlete";
    private static final String OAUTH = "/oauth/token";

    private final IAthleteDao athleteDao;
    private final RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @Autowired
    public StravaService(IAthleteDao athleteDao, RestTemplate restTemplate) {
        this.athleteDao = athleteDao;
        this.restTemplate = restTemplate;
    }

    public Optional<AthleteResponse> getProfile(String token) {
        String url = BASE_URL + ATHLETE;

        final String header = "Bearer " + token;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", header);

        HttpEntity<AuthorizationRequest> request = new HttpEntity<>(headers);

        final ResponseEntity<AthleteResponse> response = restTemplate.exchange(url, HttpMethod.GET, request, AthleteResponse.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(response.getBody());
        }
    }

    public Optional<AuthorizationResponse> refreshUserToken(String refreshToken) {
        String url = BASE_URL + OAUTH;

        AuthorizationRequest requestBody = new AuthorizationRequest(
                env.getProperty("CLIENT_ID"),
                env.getProperty("CLIENT_SECRET"),
                "refresh_token",
                refreshToken
        );

        System.out.println(requestBody.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AuthorizationRequest> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<AuthorizationResponse> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, AuthorizationResponse.class);

        if (response.getStatusCode() != HttpStatus.OK) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(response.getBody());
        }
    }
}

