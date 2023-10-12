package com.evolveum.demo.model;

public enum Status {
    IN("In", 1),
    FORMER_EMPLOYEE("Former employee", 2),
    LONG_TERM_LEAVE("Long-term leave", 3);

    public final String label;
    public final Integer order;

    private Status(String label, Integer order) {
        this.label = label;
        this.order= order;
    }
}
