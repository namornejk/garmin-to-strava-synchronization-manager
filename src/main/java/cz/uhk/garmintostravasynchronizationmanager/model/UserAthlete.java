package cz.uhk.garmintostravasynchronizationmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.net.URL;

@Entity
public class UserAthlete {

    @Id
    private long id;
    private String firstName;
    private String lastName;
    private URL profilePicture;
    private String stravaAuthorizationToken;
    private String stravaRefreshToken;
    private String userToken;

    public UserAthlete(){}

    public UserAthlete(String firstName, String lastName, URL profilePicture, String stravaAuthorizationToken, String stravaRefreshToken, String userToken) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePicture = profilePicture;
        this.stravaAuthorizationToken = stravaAuthorizationToken;
        this.stravaRefreshToken = stravaRefreshToken;
        this.userToken = userToken;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public URL getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(URL profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getStravaAuthorizationToken() {
        return stravaAuthorizationToken;
    }

    public void setStravaAuthorizationToken(String stravaAuthorizationToken) {
        this.stravaAuthorizationToken = stravaAuthorizationToken;
    }

    public String getStravaRefreshToken() {
        return stravaRefreshToken;
    }

    public void setStravaRefreshToken(String stravaRefreshToken) {
        this.stravaRefreshToken = stravaRefreshToken;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
