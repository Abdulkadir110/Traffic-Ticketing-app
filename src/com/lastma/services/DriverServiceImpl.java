package com.lastma.services;

import com.lastma.data.models.Driver;
import com.lastma.data.repositories.DriverRepository;
import com.lastma.data.repositories.DriverRepositoryImpl;

public class DriverServiceImpl implements DriverService{
    private DriverRepository driverRepository = new DriverRepositoryImpl();
    @Override
    public void register(String fullName, String email, String carPlateNumber) {
        Driver driver = new Driver();
        driver.setFullName(fullName);
        driver.setEmail(email);
        driver.setCarPlateNumber(carPlateNumber);
        driverRepository.save(driver);
    }
}
