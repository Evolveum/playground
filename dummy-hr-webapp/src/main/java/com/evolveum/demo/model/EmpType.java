package com.evolveum.demo.model;

public enum EmpType {
    FTE("FTE", 1),
    PTE("PTE", 2),
    CONTRACTOR("CONTRACTOR", 3),
    RETIRED("RETIRED", 4);

    public final String label;
    public final Integer order;

    EmpType(String label, Integer order) {

        this.label = label;
        this.order= order;
    }
}
