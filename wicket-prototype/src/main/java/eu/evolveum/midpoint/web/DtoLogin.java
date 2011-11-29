package eu.evolveum.midpoint.web;

import java.io.Serializable;

public class DtoLogin implements Serializable {

    public static final String F_USERNAME = "username";
    public static final String F_PASSWORD = "password";
    private static final long serialVersionUID = -7980634411392923714L;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return username + " " + password;
    }
}
