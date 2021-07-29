package auth;


public enum AuthenticationType {

    BASIC("Basic");

    private final String type;

    AuthenticationType(String type) {
        this.type = type;
    }


    public String getAuthenticationType() {
        return type;
    }



}
