package cz.uhk.garmintostravasynchronizationmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorizationRequest {

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("client_secret")
    private String clientSecret;

    @JsonProperty("grant_type")
    private String grantType;

    @JsonProperty("refresh_token")
    private String refreshToken;


    public AuthorizationRequest(String clientId, String clientSecret, String grantType, String refreshToken) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.grantType = grantType;
        this.refreshToken = refreshToken;
    }

    @Override
    public String toString() {
        return "AuthorizationRequest{" +
                "clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", grantType='" + grantType + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                '}';
    }

    public AuthorizationRequest() {
    }
}