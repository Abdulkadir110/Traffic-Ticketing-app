package com.lastma.dtos.reponses;

import java.util.Date;

public class FoundTicketResponse {
    private int ticketNumber;
    private String vehicleRegistrationNumber;
    private String location;
    private double accessedFine;
    private Date issuedAt;

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getAccessedFine() {
        return accessedFine;
    }

    public void setAccessedFine(double accessedFine) {
        this.accessedFine = accessedFine;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }
}