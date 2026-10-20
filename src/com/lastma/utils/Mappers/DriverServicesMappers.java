package com.lastma.utils.Mappers;

import com.lastma.data.models.Driver;
import com.lastma.dtos.reponses.FoundDriverResponseDTO;
import com.lastma.dtos.reponses.RegisterDriverResponseDTO;
import com.lastma.dtos.requests.RegisterDriverRequestDTO;

public class DriverServicesMappers {
    public static Driver mapRegisterDriver(RegisterDriverRequestDTO request) {
        Driver driver = new Driver();
        driver.setFullName(request.getFullName());
        driver.setEmail(request.getEmail());
        driver.setPassword(request.getPassword());
        driver.setPhoneNumber(request.getPhoneNumber());
        return driver;
    }
    public static RegisterDriverResponseDTO mapRegisteredDriver(Driver driver) {
        RegisterDriverResponseDTO response = new RegisterDriverResponseDTO();
        response.setFullName(driver.getFullName());
        response.setEmail(driver.getEmail());
        response.setPhoneNumber(driver.getPhoneNumber());
        return response;
    }
    public static FoundDriverResponseDTO mapFoundDriver(Driver driver) {
        FoundDriverResponseDTO response = new FoundDriverResponseDTO();
        response.setFullName(driver.getFullName());
        response.setEmail(driver.getEmail());
        response.setPhoneNumber(driver.getPhoneNumber());
        response.setId(driver.getId());
        return response;
    }
}
