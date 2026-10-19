package com.lastma.data.models;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    private int id;
    private String fullName;
    private String email;
    private String carPlateNumber;
    private String password;
    private List<Ticket> tickets = new ArrayList<>();
    private List<Vehicle>  vehicles = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarPlateNumber() {
        return carPlateNumber;
    }

    public void setCarPlateNumber(String carPlateNumber) {
        this.carPlateNumber = carPlateNumber;
    }

    public String toString() {
        return "id : " + getId() + " name: " + getFullName() + " email: " + getEmail();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Ticket tickets) {
        this.tickets.add(tickets);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
