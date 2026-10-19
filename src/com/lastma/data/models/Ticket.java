package com.lastma.data.models;

import java.util.Date;

public class Ticket {
    private int id;
    private int ticketNumber;
    private int vehicleId;
    private int offenceId;
    private Date incidentDateTime;
    private String location;
    private String description;
    private double accessedFine;
    private PaymentStatus paymentStatus;
    private Date issuedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
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