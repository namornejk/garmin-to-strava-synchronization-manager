package cz.uhk.garmintostravasynchronizationmanager.model.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WebhookRequest {

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("client_secret")
    private String clientSecret;

    @JsonProperty("callback_url")
    private String callbackUrl;

    @JsonProperty("verify_token")
    private String verifyToken;
}
