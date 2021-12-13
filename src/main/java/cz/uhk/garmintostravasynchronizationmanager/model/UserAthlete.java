package cz.uhk.garmintostravasynchronizationmanager.model;

import cz.uhk.garmintostravasynchronizationmanager.model.filters.ActivityFilter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

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

    @OneToMany( mappedBy="user" )
    private List<ActivityFilter> filters;

    private String stravaAuthorizationToken;

    @JsonIgnore
    private String stravaRefreshToken;

    @JsonIgnore
    @Column(length = 1200)
    private String userToken;

}
