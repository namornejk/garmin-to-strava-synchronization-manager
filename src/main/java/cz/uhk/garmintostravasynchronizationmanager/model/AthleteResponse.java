package cz.uhk.garmintostravasynchronizationmanager.model;


public class AthleteResponse {

    private String id;
    private String username;
    private String firstname;
    private String lastname;
    private String profile_medium;

    public AthleteResponse(String id, String username, String firstname, String lastname, String profile_medium) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.profile_medium = profile_medium;
    }

    public AthleteResponse() { }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getProfile_medium() {
        return profile_medium;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", profile_medium='" + profile_medium + '\'' +
                '}';
    }
}
