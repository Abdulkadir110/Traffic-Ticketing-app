package com.lastma.services;

import com.lastma.data.models.Driver;
import com.lastma.data.repositories.DriverRepository;
import com.lastma.data.repositories.DriverRepositoryImpl;
import com.lastma.dtos.reponses.FindDriverResponses;


public class DriverServiceImpl implements DriverService{
    private DriverRepository driverRepository = new DriverRepositoryImpl();

    @Override
    public FindDriverResponses register(String fullName, String email, String phoneNumber, String password) {
        Driver driver = new Driver();
        driver.setFullName(fullName);
        driver.setEmail(email);
        driver.setPhoneNumber(phoneNumber);
        Driver registeredDriver = driverRepository.save(driver);
        FindDriverResponses response = new FindDriverResponses();
        response.setFullName(registeredDriver.getFullName());
        response.setEmail(registeredDriver.getEmail());
        response.setPhoneNumber(registeredDriver.getPhoneNumber());

        return response;
    }

    @Override
    public FindDriverResponses findById(int id) {
        Driver foundDriver = driverRepository.findById(id);
        FindDriverResponses response = new FindDriverResponses();
        response.setFullName(foundDriver.getFullName());
        response.setEmail(foundDriver.getEmail());
        response.setPhoneNumber(foundDriver.getPhoneNumber());
        return response;
    }


}
