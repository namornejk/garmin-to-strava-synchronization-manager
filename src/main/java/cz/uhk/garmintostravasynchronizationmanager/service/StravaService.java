package cz.uhk.garmintostravasynchronizationmanager.service;

import cz.uhk.garmintostravasynchronizationmanager.model.*;
import cz.uhk.garmintostravasynchronizationmanager.model.webhook.WebhookId;
import cz.uhk.garmintostravasynchronizationmanager.model.webhook.WebhookRequest;
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

    //TODO: upravit dle nasazení
    protected String CALLBACK_BASE_URL = "http://0bb2-194-12-38-64.ngrok.io";

    private static final String ATHLETE = "/athlete";
    private static final String ATHLETE_ACTIVITIES = "/athlete/activities";
    private static final String ACTIVITIES = "/activities";
    private static final String OAUTH = "/oauth/token";
    private static final String SUBSCRIPTIONS = "/push_subscriptions";
    private static final String EVENTS = "/webhook";

    private final RestTemplate restTemplate;

    private final Environment env;

    @Autowired
    public StravaService(RestTemplate restTemplate, Environment env) {
        this.restTemplate = restTemplate;
        this.env = env;
    }

    public Optional<AthleteResponse> getProfile(String token) {
        final String url = BASE_URL + ATHLETE;

        final HttpHeaders headers = createJsonHeader();
        headers.set("Authorization", bearerToken(token));

        final ResponseEntity<AthleteResponse> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<AuthorizationRequest>(headers), AthleteResponse.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(response.getBody());
        }
    }

    public Optional<AthleteActivityResponse> getActivityDetail(long id, String token) {
        final String url = BASE_URL + ACTIVITIES + "/" + id + "?include_all_efforts=false";

        final HttpHeaders headers = createJsonHeader();
        headers.set("Authorization", bearerToken(token));

        final ResponseEntity<AthleteActivityResponse> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), AthleteActivityResponse.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(response.getBody());
        }
    }

    public Optional<AthleteAuthorizationResponse> authorize(String code) {
        final String url = BASE_URL + OAUTH;

        final UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("client_id", env.getProperty("CLIENT_ID"))
                .queryParam("client_secret", env.getProperty("CLIENT_SECRET"))
                .queryParam("grant_type", "authorization_code")
                .queryParam("code", code).build();

        ResponseEntity<AthleteAuthorizationResponse> response = restTemplate.exchange(builder.toString(), HttpMethod.POST, new HttpEntity<>(null, createJsonHeader()), AthleteAuthorizationResponse.class);

        if (response.getStatusCode() != HttpStatus.OK) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(response.getBody());
        }
    }

    public Optional<AuthorizationResponse> refreshUserToken(String refreshToken) {
        final String url = BASE_URL + OAUTH;

        final AuthorizationRequest requestBody = new AuthorizationRequest(
                env.getProperty("CLIENT_ID"),
                env.getProperty("CLIENT_SECRET"),
                "refresh_token",
                refreshToken
        );

        final ResponseEntity<AuthorizationResponse> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(requestBody, createJsonHeader()),
                AuthorizationResponse.class);

        if (response.getStatusCode() != HttpStatus.OK) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(response.getBody());
        }
    }

    public Optional<List<AthleteActivityResponse>> getUserActivities(String token) {
        final String url = BASE_URL + ATHLETE_ACTIVITIES;

        final HttpHeaders header = createJsonHeader();
        header.set("Authorization", bearerToken(token));

        final ResponseEntity<AthleteActivityResponse[]> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(header), AthleteActivityResponse[].class);

        if (response.getStatusCode() != HttpStatus.OK) {
            return Optional.empty();
        } else {
            return Optional.of(Arrays.asList(Objects.requireNonNull(response.getBody())));
        }
    }

    public ResponseEntity<WebhookId> subscribeToWebhook() {
        final String url = BASE_URL + SUBSCRIPTIONS;

        final WebhookRequest requestBody = new WebhookRequest(
                env.getProperty("CLIENT_ID"),
                env.getProperty("CLIENT_SECRET"),
                CALLBACK_BASE_URL + EVENTS,
                env.getProperty("APP_TOKEN")
        );

        final HttpEntity<WebhookRequest> requestEntity = new HttpEntity<>(requestBody, createJsonHeader());
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, WebhookId.class);
    }

    public HttpStatus checkVerifiedToken(String token) {
        String serverToken = env.getProperty("APP_TOKEN");

        if (Objects.requireNonNull(serverToken).equals(token)) {
            return HttpStatus.OK;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }

    private HttpHeaders createJsonHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private String bearerToken(String token) {
        return "Bearer " + token;
    }
}

