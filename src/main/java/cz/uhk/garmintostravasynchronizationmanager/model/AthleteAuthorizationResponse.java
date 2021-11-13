package cz.uhk.garmintostravasynchronizationmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AthleteAuthorizationResponse {

    @JsonProperty("access_token")
    private String token;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("athlete")
    private AthleteResponse athlete;

    public AthleteAuthorizationResponse(String token, String refreshToken, AthleteResponse athlete) {
        this.token = token;
        this.refreshToken = refreshToken;
        this.athlete = athlete;
    }

    public AthleteAuthorizationResponse() {
    }
}
