package com.evolveum.demo.model;

public enum Status {
    IN("In"),
    FORMER_EMPLOYEE("Former employee"),
    LONG_TERM_LEAVE("Long-term leave");

    public final String label;

    private Status(String label) {
        this.label = label;
    }
}
