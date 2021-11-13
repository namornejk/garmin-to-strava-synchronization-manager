package cz.uhk.garmintostravasynchronizationmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthCodeRequest {

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("client_secret")
    private String clientSecret;

    @JsonProperty("grant_type")
    private String grantType;

    private String code;

    public AuthCodeRequest(String clientId, String clientSecret, String grantType, String code) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.grantType = grantType;
        this.code = code;
    }

    public AuthCodeRequest() {
    }

    @Override
    public String toString() {
        return "AuthCodeRequest{" +
                "clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", grantType='" + grantType + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
