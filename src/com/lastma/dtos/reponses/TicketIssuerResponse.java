package com.lastma.dtos.reponses;

import com.lastma.data.models.PaymentStatus;

import java.util.Date;

public class TicketIssuerResponse {
    private String vehicleId;
    private int offenceId;
    private Date incidentDateTime;
    private String location;
    private String description;
    private double accessedFine;
    private PaymentStatus paymentStatus;
    private Date issuedAt;

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getOffenceId() {
        return offenceId;
    }

    public void setOffenceId(int offenceId) {
        this.offenceId = offenceId;
    }

    public Date getIncidentDateTime() {
        return incidentDateTime;
    }

    public void setIncidentDateTime(Date incidentDateTime) {
        this.incidentDateTime = incidentDateTime;
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

    public double getAccessedFine() {
        return accessedFine;
    }

    public void setAccessedFine(double accessedFine) {
        this.accessedFine = accessedFine;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }
}
