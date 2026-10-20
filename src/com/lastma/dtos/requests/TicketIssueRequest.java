package com.lastma.dtos.requests;

import java.util.Date;

public class TicketIssueRequest {
    private String vehicleRegistrationNumber;
    private int offenceId;
    private String location;
    private String description;
    private Date incidentDateTime;

    public String getVehicleId() {
        return vehicleRegistrationNumber;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleRegistrationNumber = vehicleId;
    }

    public int getOffenceId() {
        return offenceId;
    }

    public void setOffenceId(int offenceId) {
        this.offenceId = offenceId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getIncidentDateTime() {
        return incidentDateTime;
    }

    public void setIncidentDateTime(Date incidentDateTime) {
        this.incidentDateTime = incidentDateTime;
    }
}
