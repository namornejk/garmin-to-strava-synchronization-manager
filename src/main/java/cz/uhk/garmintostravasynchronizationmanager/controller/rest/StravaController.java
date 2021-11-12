package cz.uhk.garmintostravasynchronizationmanager.controller.rest;

import cz.uhk.garmintostravasynchronizationmanager.model.AthleteResponse;
import cz.uhk.garmintostravasynchronizationmanager.model.AuthorizationResponse;
import cz.uhk.garmintostravasynchronizationmanager.service.StravaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StravaController {

    private final StravaService stravaService;

    @Autowired
    public StravaController(StravaService stravaService) {
        this.stravaService = stravaService;
    }

    @GetMapping("/athlete")
    public AthleteResponse fetchProfile(@RequestParam(name = "token") String token) {
        return stravaService.getProfile(token).get();
    }

    @PostMapping("/refreshToken")
    public AuthorizationResponse refreshToken(@RequestParam(name = "token") String token) {
        return stravaService.refreshUserToken(token).get();
    }
}

