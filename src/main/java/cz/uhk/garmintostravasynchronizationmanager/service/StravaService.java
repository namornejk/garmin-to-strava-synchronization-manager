package cz.uhk.garmintostravasynchronizationmanager.service;

import cz.uhk.garmintostravasynchronizationmanager.constants.ApiConstants;
import cz.uhk.garmintostravasynchronizationmanager.dao.AthleteDao;
import cz.uhk.garmintostravasynchronizationmanager.model.*;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Service
public class StravaService {

    protected String BASE_URL = "https://www.strava.com/api/v3";

    private static final String ATHLETE = "/athlete";
    private static final String ACTIVITIES = "/athlete/activities";
    private static final String OAUTH = "/oauth/token";

    private final RestTemplate restTemplate;

    private final Environment env;

    @Autowired
    public StravaService(RestTemplate restTemplate, Environment env) {
        this.restTemplate = restTemplate;
        this.env = env;
    }

    public Optional<AthleteResponse> getProfile(String token) {
        String url = BASE_URL + ATHLETE;

        HttpHeaders headers = createJsonHeader();
        headers.set("Authorization", bearerToken(token));

        HttpEntity<AuthorizationRequest> request = new HttpEntity<>(headers);

        final ResponseEntity<AthleteResponse> response = restTemplate.exchange(url, HttpMethod.GET, request, AthleteResponse.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(response.getBody());
        }
    }

    public Optional<AthleteAuthorizationResponse> authorize(String code) {
        String url = BASE_URL + OAUTH;

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("client_id", env.getProperty("CLIENT_ID"))
                .queryParam("client_secret",env.getProperty("CLIENT_SECRET"))
                .queryParam("grant_type","authorization_code")
                .queryParam("code",code).build();

        HttpEntity<AuthCodeRequest> requestEntity = new HttpEntity<>(null, createJsonHeader());
        ResponseEntity<AthleteAuthorizationResponse> response = restTemplate.exchange(builder.toString(), HttpMethod.POST, requestEntity, AthleteAuthorizationResponse.class);

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

        HttpEntity<AuthorizationRequest> requestEntity = new HttpEntity<>(requestBody, createJsonHeader());
        ResponseEntity<AuthorizationResponse> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, AuthorizationResponse.class);

        if (response.getStatusCode() != HttpStatus.OK) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(response.getBody());
        }
    }

    public Optional<List<AthleteActivityResponse>> getUserActivities(String token) {
        String url = BASE_URL + ACTIVITIES;

        HttpHeaders header = createJsonHeader();
        header.set(ApiConstants.HEADER_NAME, bearerToken(token));

        HttpEntity<AthleteActivityResponse> requestEntity = new HttpEntity<>(header);
        ResponseEntity<AthleteActivityResponse[]> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, AthleteActivityResponse[].class);

        if (response.getStatusCode() != HttpStatus.OK) {
            return Optional.empty();
        } else {
            return Optional.of(Arrays.asList(Objects.requireNonNull(response.getBody())));
        }
    }

    private HttpHeaders createJsonHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private String bearerToken(String token) {
        return token;
    }
}

