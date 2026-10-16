package com.lastma.data.repositories;

import com.lastma.data.models.Vehicle;

public interface VehicleRepository {
    long count();
    Vehicle save(Vehicle vehicle);
}
