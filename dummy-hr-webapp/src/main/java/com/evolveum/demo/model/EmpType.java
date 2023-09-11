package com.evolveum.demo.model;

public enum EmpType {
    FTE("FTE"), PTE("PTE"), CONTRACTOR("CONTRACTOR"), RETIRED("RETIRED");

    public final String label;

    EmpType(String label) {

        this.label = label;
    }
}
