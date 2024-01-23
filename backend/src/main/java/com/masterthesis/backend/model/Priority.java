package com.masterthesis.backend.model;

public enum Priority {

    HIGH("high"),
    MEDIUM("medium"),
    ADMIN("low");

    private final String prio;

    Priority(String prio) {
        this.prio = prio;
    }

    public String getPrio() {
        return this.prio;
    }
}
