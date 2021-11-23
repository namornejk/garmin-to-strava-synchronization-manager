package cz.uhk.garmintostravasynchronizationmanager.model.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class WebhookConfirmResponse {

    @JsonProperty("hub.challenge")
    private final String hubChallenge;
}
