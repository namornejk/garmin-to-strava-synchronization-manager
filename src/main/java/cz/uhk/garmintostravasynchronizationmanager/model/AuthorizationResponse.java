package cz.uhk.garmintostravasynchronizationmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorizationResponse {

    @JsonProperty("access_token")
    private String token;

    @JsonProperty("refresh_token")
    private String refreshToken;

    public AuthorizationResponse(String token, String refreshToken) {
        this.token = token;
        this.refreshToken = refreshToken;
    }

    public AuthorizationResponse() { }
}
