package cz.uhk.garmintostravasynchronizationmanager.controller.rest;

import cz.uhk.garmintostravasynchronizationmanager.model.*;
import cz.uhk.garmintostravasynchronizationmanager.model.webhook.WebhookConfirmResponse;
import cz.uhk.garmintostravasynchronizationmanager.model.webhook.WebhookEvent;
import cz.uhk.garmintostravasynchronizationmanager.service.StravaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping(value = "/webhook")
    @ResponseBody
    public ResponseEntity subscribe(@RequestBody WebhookEvent webhookEvent) {
        if (webhookEvent != null) {
            return ResponseEntity.ok(webhookEvent);
        } else {
            return stravaService.subscribeToWebhook();
        }
    }

    @GetMapping("/webhook")
    public ResponseEntity<WebhookConfirmResponse> confirmWebhook(@RequestParam(name = "hub.challenge") String hubChallenge, @RequestParam(name = "hub.verify_token") String verifyToken) {
        if (verifyToken != null) {
            final HttpStatus status = stravaService.checkVerifiedToken(verifyToken);
            return ResponseEntity.status(status).body(new WebhookConfirmResponse(hubChallenge));
        } else {
            return ResponseEntity.status(400).build();
        }
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

