package cz.uhk.garmintostravasynchronizationmanager.model;

import lombok.Data;

@Data
public class UserTokenResponse {

    final String token;
    final UserAthlete user;

}
