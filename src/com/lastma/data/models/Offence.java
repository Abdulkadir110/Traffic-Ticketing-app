package com.lastma.data.models;

public class Offence {
    private int id;
    private String code;
    private ViolationType type;
    private String description;
    private double firstOffenceFine;
    private double subsequentOffenceFine;
    private String additionalPenaltyDescription;
    private boolean active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getFirstOffenceFine() {
        return firstOffenceFine;
    }

    public void setFirstOffenceFine(double firstOffenceFine) {
        this.firstOffenceFine = firstOffenceFine;
    }

    public double getSubsequentOffenceFine() {
        return subsequentOffenceFine;
    }

    public void setSubsequentOffenceFine(double subsequentOffenceFine) {
        this.subsequentOffenceFine = subsequentOffenceFine;
    }

    public String getAdditionalPenaltyDescription() {
        return additionalPenaltyDescription;
    }

    public void setAdditionalPenaltyDescription(String additionalPenaltyDescription) {
        this.additionalPenaltyDescription = additionalPenaltyDescription;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ViolationType getType() {
        return type;
    }

    public void setType(ViolationType type) {
        this.type = type;
    }
}