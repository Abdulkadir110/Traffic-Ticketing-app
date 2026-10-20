package com.lastma.dtos.requests;

import com.lastma.data.models.ViolationType;

public class CreateOffenceRequestDTO {
    private String code;
    private ViolationType offenceType;
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ViolationType getOffenceType() {
        return offenceType;
    }

    public void setOffenceType(ViolationType offenceType) {
        this.offenceType = offenceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
