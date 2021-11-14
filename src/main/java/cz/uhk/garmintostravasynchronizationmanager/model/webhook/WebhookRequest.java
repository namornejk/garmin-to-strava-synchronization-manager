package cz.uhk.garmintostravasynchronizationmanager.model.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebhookRequest {

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("client_secret")
    private String clientSecret;

    @JsonProperty("callback_url")
    private String callbackUrl;

    @JsonProperty("verify_token")
    private String verifyToken;

    public WebhookRequest(String clientId, String clientSecret, String callbackUrl, String verifyToken) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.callbackUrl = callbackUrl;
        this.verifyToken = verifyToken;
    }

    @Override
    public String toString() {
        return "WebhookRequest{" +
                "clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", callbackUrl='" + callbackUrl + '\'' +
                '}';
    }

    public WebhookRequest() {
    }
}
