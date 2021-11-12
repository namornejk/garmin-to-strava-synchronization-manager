package cz.uhk.garmintostravasynchronizationmanager.service;

import cz.uhk.garmintostravasynchronizationmanager.dao.IAthleteDao;
import cz.uhk.garmintostravasynchronizationmanager.model.Athlete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Optional;

@Service
public class StravaService {

    protected String BASE_URL = "https://www.strava.com/api/v3";

    private static final String ATHLETE = "/athlete";
    private static final String ACTIVITY = "/activity";

    private final IAthleteDao athleteDao;
    private final RestTemplate restTemplate;

    @Autowired
    public StravaService(IAthleteDao athleteDao, RestTemplate restTemplate) {
        this.athleteDao = athleteDao;
        this.restTemplate = restTemplate;
    }

    public Optional<Athlete> getProfile(String token) {
        String url = BASE_URL + ATHLETE;

        final String header  = "Bearer " + token;

        RequestEntity<Void> request = RequestEntity.get(URI.create(url))
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", header)
                .build();

        final ResponseEntity<Athlete> response = restTemplate.exchange(request, Athlete.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(response.getBody());
        }
    }
}

