package cz.uhk.garmintostravasynchronizationmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class UserAthlete {

    @Id
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String profilePicture;

    @JsonIgnore
    private String stravaAuthorizationToken;

    @JsonIgnore
    private String stravaRefreshToken;

    @JsonIgnore
    @Column(length = 1200)
    private String userToken;

}
