package cz.uhk.garmintostravasynchronizationmanager.controller.rest;

import cz.uhk.garmintostravasynchronizationmanager.model.webhook.WebhookConfirmResponse;
import cz.uhk.garmintostravasynchronizationmanager.model.webhook.WebhookEvent;
import cz.uhk.garmintostravasynchronizationmanager.service.StravaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Webhook", tags = "Webhook")
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

    @Operation(summary = "Confirms webhook setup", description = "Confirms when Strava wants to communicate with this API.", tags = {"Webhook"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Webhook confirmed", content = @Content(schema = @Schema(implementation = WebhookConfirmResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error"),
    })
    @GetMapping()
    public ResponseEntity<WebhookConfirmResponse> confirmWebhook(@RequestParam(name = "hub.challenge") String hubChallenge, @RequestParam(name = "hub.verify_token") String verifyToken) {
        final HttpStatus status = stravaService.checkVerifiedToken(hubChallenge, verifyToken);
        return ResponseEntity.status(status).body(new WebhookConfirmResponse(hubChallenge));
    }
}
