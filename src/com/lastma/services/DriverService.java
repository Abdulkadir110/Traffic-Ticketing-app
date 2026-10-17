package com.lastma.services;

import com.lastma.data.models.VehicleType;

import java.time.Year;

public interface DriverService {
    void register(String fullName, String email, String carPlateNumber,String password);
    void registerVehicle(int id, String brand, String model, VehicleType carType, Year carYear, String plateNumber);
}
