package com.lastma.services;

import com.lastma.data.models.Driver;
import com.lastma.data.models.VehicleType;
import com.lastma.data.models.ViolationType;

import java.time.Year;

public interface DriverService {
    Driver register(String fullName, String email, String carPlateNumber, String password);
    void registerVehicle(int id, String brand, String model, VehicleType carType, Year carYear, String plateNumber);

    void makePayment(int ticketId, ViolationType violationType, double amount);
}
