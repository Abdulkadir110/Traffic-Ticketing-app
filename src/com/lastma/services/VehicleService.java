package com.lastma.services;

import com.lastma.dtos.reponses.FindVehicleResponses;
import com.lastma.dtos.requests.RegisterVehicleRequest;

public interface VehicleService {
    FindVehicleResponses registerVehicle(RegisterVehicleRequest request);
}
