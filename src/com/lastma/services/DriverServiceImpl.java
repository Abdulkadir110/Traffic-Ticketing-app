package com.lastma.services;

import com.lastma.data.models.Driver;
import com.lastma.data.repositories.DriverRepository;
import com.lastma.data.repositories.DriverRepositoryImpl;
import com.lastma.dtos.reponses.FindDriverDetails;


public class DriverServiceImpl implements DriverService{
    private DriverRepository driverRepository = new DriverRepositoryImpl();

    @Override
    public FindDriverDetails register(String fullName, String email, String phoneNumber, String password) {
        Driver driver = new Driver();
        driver.setFullName(fullName);
        driver.setEmail(email);
        driver.setPhoneNumber(phoneNumber);
        Driver registeredDriver = driverRepository.save(driver);
        FindDriverDetails details = new FindDriverDetails();
        details.setFullName(registeredDriver.getFullName());
        details.setEmail(registeredDriver.getEmail());
        details.setPhoneNumber(registeredDriver.getPhoneNumber());

        return details;
    }

}
