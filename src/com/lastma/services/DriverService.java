package com.lastma.services;

import com.lastma.dtos.reponses.FindDriverResponses;

public interface DriverService {
    FindDriverResponses register(String fullName, String email, String phoneNumber, String password);
    FindDriverResponses findById(int id);
}
