package com.lastma.services;

import com.lastma.data.models.Driver;
import com.lastma.data.models.Vehicle;
import com.lastma.data.models.VehicleType;
import com.lastma.data.repositories.DriverRepository;
import com.lastma.data.repositories.DriverRepositoryImpl;
import com.lastma.data.repositories.VehicleRepository;
import com.lastma.data.repositories.VehicleRepositoryImpl;

import java.time.Year;

public class DriverServiceImpl implements DriverService{
    private DriverRepository driverRepository = new DriverRepositoryImpl();
    private VehicleRepository vehicleRepository = new VehicleRepositoryImpl();
    @Override
    public void register(String fullName, String email, String carPlateNumber, String password) {
        Driver driver = new Driver();
        driver.setFullName(fullName);
        driver.setEmail(email);
        driver.setCarPlateNumber(carPlateNumber);
        driverRepository.save(driver);
    }

    @Override
    public void registerVehicle(int id, String brand, String model, VehicleType carType, Year carYear, String plateNumber) {
        validateDriver(id);
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(brand);
        vehicle.setModel(model);
        vehicle.setType(carType);
        vehicle.setYear(carYear);
        vehicle.setCarPlateNumber(plateNumber);
        vehicleRepository.save(vehicle);

    }
    private void validateDriver(int id) {
       Driver foundDriver = driverRepository.findById(id);
       if (foundDriver == null) throw new IllegalArgumentException("Driver with id " + id + " not found");
    }
}
