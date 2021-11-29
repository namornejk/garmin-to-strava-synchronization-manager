package cz.uhk.garmintostravasynchronizationmanager.controller.rest;

import cz.uhk.garmintostravasynchronizationmanager.model.webhook.WebhookConfirmResponse;
import cz.uhk.garmintostravasynchronizationmanager.model.webhook.WebhookEvent;
import cz.uhk.garmintostravasynchronizationmanager.service.StravaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/webhook")
public class WebhookController {

    private final StravaService stravaService;

    @Autowired
    public WebhookController(StravaService stravaService) {
        this.stravaService = stravaService;
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity subscribe(@RequestBody WebhookEvent webhookEvent) {
        if (webhookEvent != null) {
            //TODO: do something with event
            return ResponseEntity.ok(webhookEvent);
        } else {
            return stravaService.subscribeToWebhook();
        }
    }

    @GetMapping()
    public ResponseEntity<WebhookConfirmResponse> confirmWebhook(@RequestParam(name = "hub.challenge") String hubChallenge, @RequestParam(name = "hub.verify_token") String verifyToken) {
        final HttpStatus status = stravaService.checkVerifiedToken(hubChallenge, verifyToken);
        return ResponseEntity.status(status).body(new WebhookConfirmResponse(hubChallenge));
    }
}
