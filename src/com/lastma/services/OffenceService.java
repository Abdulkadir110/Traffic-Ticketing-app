package com.lastma.services;

import com.lastma.data.models.ViolationType;
import com.lastma.dtos.reponses.FindOffenceResponses;

public interface OffenceService {
    FindOffenceResponses generateOffence(String code, ViolationType offenceType, String description);
}
