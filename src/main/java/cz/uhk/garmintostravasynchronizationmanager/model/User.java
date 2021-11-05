package cz.uhk.garmintostravasynchronizationmanager.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String password;
    private String username;
    private String firstName;
    private String sureName;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Activity> activities;

    private String token;
    private String refreshToken;
    private String secret;
    private String code;

    public User(){}

    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public User(String password, String username, String token, String refreshToken, String secret, String code) {
        this.password = password;
        this.username = username;
        this.token = token;
        this.refreshToken = refreshToken;
        this.secret = secret;
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
