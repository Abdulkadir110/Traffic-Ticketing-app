package com.lastma.dtos.reponses;

public class CreateOffenceResponseDTO {
    private int offenceId;
    private String code;
    private String description;
    private double firstOffenceFine;

    public int getOffenceId() {
        return offenceId;
    }

    public void setOffenceId(int offenceId) {
        this.offenceId = offenceId;
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
}
