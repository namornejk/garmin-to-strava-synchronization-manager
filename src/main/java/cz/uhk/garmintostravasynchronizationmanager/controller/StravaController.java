package cz.uhk.garmintostravasynchronizationmanager.controller;

import cz.uhk.garmintostravasynchronizationmanager.model.*;
import cz.uhk.garmintostravasynchronizationmanager.service.StravaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@ApiIgnore
@RestController
public class StravaController {

    private final StravaService stravaService;

    @Autowired
    public StravaController(StravaService stravaService) {
        this.stravaService = stravaService;
    }

    @PostMapping("/refreshToken")
    public AuthorizationResponse refreshToken(@RequestParam(name = "token") String token) {
        return stravaService.refreshUserToken(token).get();
    }

    @PostMapping("/authorize")
    public AthleteAuthorizationResponse authorize(@RequestParam(name = "code") String code) {
        return stravaService.authorize(code).get();
    }

    @GetMapping("/athlete")
    public AthleteResponse fetchProfile(@RequestHeader(name = "Authorization") String token) {
        return stravaService.getProfile(token).get();
    }

    @GetMapping("/activities")
    public List<AthleteActivityResponse> fetchUserActivities(@RequestHeader(name = "Authorization") String token) {
        return stravaService.getUserActivities(token).get();
    }

    @GetMapping("/activities/{id}")
    public AthleteActivityResponse fetchUserActivityDetail(@RequestHeader(name = "Authorization") String token, @PathVariable(name = "id") long id) {
        return stravaService.getActivityDetail(id, token).get();
    }
}

