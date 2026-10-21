package com.lastma.services;

import com.lastma.data.models.Driver;
import com.lastma.data.repositories.DriverRepository;
import com.lastma.data.repositories.DriverRepositoryImpl;
import com.lastma.dtos.reponses.FoundDriverResponseDTO;
import com.lastma.dtos.reponses.RegisterDriverResponseDTO;
import com.lastma.dtos.requests.FindDriverRequest;
import com.lastma.dtos.requests.RegisterDriverRequestDTO;

import static com.lastma.utils.Mappers.DriverServicesMappers.*;


public class DriverServiceImpl implements DriverService{
    private DriverRepository driverRepository = new DriverRepositoryImpl();

    @Override
    public RegisterDriverResponseDTO register(RegisterDriverRequestDTO request) {
        Driver registerDriver = driverRepository.save(mapRegisterDriver(request));
        validate(registerDriver);
        return mapRegisteredDriver(registerDriver);
    }

    private void validate(Driver driver) {
        if (driver == null)throw new IllegalArgumentException("Driver not found");
    }


    @Override
    public FoundDriverResponseDTO findDriverById(FindDriverRequest request) {
        Driver foundDriver = driverRepository.findById(request.getId());
        validate(foundDriver);
        return mapFoundDriver(foundDriver);
    }
}
