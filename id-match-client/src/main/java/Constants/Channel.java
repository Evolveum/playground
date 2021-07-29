package Constants;

public enum Channel {

    URL_PREFIX_MAIN_OPERATIONS("http://localhost:8070/match/api/2/v1/people/"),
    URL_MATCH_REQUEST_PENDING("http://localhost:8070/match/api/2/v1/matchRequests?status=pending"),
    URL_MATCH_REQUEST_RESOLVED("http://localhost:8070/match/api/2/v1/matchRequests?status=resolved"),
    URL_PREFIX_GET_MATCH_REQUEST_MATCH_ID("http://localhost:8070/match/api/2/v1/matchRequests/"),
    URL_PREFIX_GET_MATCH_REQUEST_REFERENCE_ID("http://localhost:8070/match/api/2/v1/matchRequests?referenceId=");


    private final String url;

    Channel(String envUrl) {
        this.url = envUrl;
    }

    public String getUrl() {
        return url;
    }
}


