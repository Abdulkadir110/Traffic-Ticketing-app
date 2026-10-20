package com.lastma.services;

import com.lastma.dtos.reponses.RegisterVehicleResponse;
import com.lastma.dtos.requests.RegisterVehicleRequest;

public interface VehicleService {
    RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request);
}
