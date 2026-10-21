package com.lastma.services;

import com.lastma.dtos.reponses.FoundDriverResponseDTO;
import com.lastma.dtos.reponses.RegisterDriverResponseDTO;
import com.lastma.dtos.requests.FindDriverRequest;
import com.lastma.dtos.requests.RegisterDriverRequestDTO;


public interface DriverService {
    RegisterDriverResponseDTO register(RegisterDriverRequestDTO request);
    FoundDriverResponseDTO findDriverById(FindDriverRequest request);
}
