package cz.uhk.garmintostravasynchronizationmanager.model.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebhookConfirmResponse {

    @JsonProperty("hub.challenge")
    final String hubChallenge;

    public WebhookConfirmResponse(String hubChallenge) {
        this.hubChallenge = hubChallenge;
    }
}
