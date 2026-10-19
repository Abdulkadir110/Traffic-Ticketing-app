package com.lastma.services;

import com.lastma.data.models.Driver;
import com.lastma.data.models.VehicleType;
import com.lastma.data.models.ViolationType;
import com.lastma.dtos.reponses.FindDriverDetails;

import java.time.Year;

public interface DriverService {
    FindDriverDetails register(String fullName, String email, String phoneNumber, String password);

}
