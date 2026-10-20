package com.lastma.services;


import com.lastma.data.models.Vehicle;
import com.lastma.data.repositories.VehicleRepository;
import com.lastma.data.repositories.VehicleRepositoryImpl;
import com.lastma.dtos.reponses.FindVehicleResponses;
import com.lastma.dtos.requests.RegisterVehicleRequest;
import com.lastma.utils.Mappers.VehicleServicesMappers;

import static com.lastma.utils.Mappers.VehicleServicesMappers.mapFrom;

public class VehicleServiceImpl implements  VehicleService {
    private VehicleRepository vehicleRepository = new VehicleRepositoryImpl();
    @Override
    public FindVehicleResponses registerVehicle(RegisterVehicleRequest request) {
        Vehicle vehicle = VehicleServicesMappers.mapRegister(request);
        Vehicle registeredVehicle = vehicleRepository.save(vehicle);
        return mapFrom(registeredVehicle);
    }
}
