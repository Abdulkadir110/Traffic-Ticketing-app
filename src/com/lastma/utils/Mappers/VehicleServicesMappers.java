package com.lastma.utils.Mappers;

import com.lastma.data.models.Vehicle;
import com.lastma.dtos.reponses.FindVehicleResponses;
import com.lastma.dtos.requests.RegisterVehicleRequest;

public class VehicleServicesMappers {
    public static Vehicle mapRegister(RegisterVehicleRequest request){
        Vehicle vehicle = new Vehicle();
        vehicle.setRegistrationNumber(request.getRegistrationNumber());
        vehicle.setColor(request.getColor());
        vehicle.setModel(request.getModel());
        vehicle.setMake(request.getMake());
        vehicle.setDriverId(request.getDriverId());
        return vehicle;
    }
    public static FindVehicleResponses mapFrom(Vehicle vehicle){
        FindVehicleResponses response = new FindVehicleResponses();
        response.setColor(vehicle.getColor());
        response.setModel(vehicle.getModel());
        response.setMake(vehicle.getMake());
        response.setRegistrationNumber(vehicle.getRegistrationNumber());
        return response;
    }
}
