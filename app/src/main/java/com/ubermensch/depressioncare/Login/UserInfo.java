package com.ubermensch.depressioncare.Login;

public class UserInfo {
    private String username;
    private String profile;

    public UserInfo() {}

    public UserInfo(String userName, String profile) {
        this.username = userName;
        this.profile = profile;
    }

    public String getUserName(){
        return username;
    }
    public String getProfile(){
        return profile;
    }
}
