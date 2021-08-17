package com.evolveum.playground.idmatch.constants;

public enum MatchStatus {


    PENDING("/match/api/2/v1/matchRequests?status=pending"),
    RESOLVED("/match/api/2/v1/matchRequests?status=resolved");


    private final String url;

    MatchStatus(String envUrl) {
        this.url = envUrl;
    }

    public String getUrl() {
        return url;
    }

}
