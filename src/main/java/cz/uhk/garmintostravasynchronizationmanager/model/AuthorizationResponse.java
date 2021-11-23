package cz.uhk.garmintostravasynchronizationmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AuthorizationResponse {

    @JsonProperty("access_token")
    private String token;

    @JsonProperty("refresh_token")
    private String refreshToken;

}
