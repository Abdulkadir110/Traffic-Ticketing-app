package com.lastma.services;

import com.lastma.data.models.Challenge;
import com.lastma.data.repositories.ChallengeRepository;
import com.lastma.data.repositories.ChallengeRepositoryImpl;
import com.lastma.dtos.reponses.SubmitChallengeResponse;
import com.lastma.dtos.requests.SubmitChallengeRequest;

import static com.lastma.utils.Mappers.ChallengeServiceMappers.mapChallengeRequest;
import static com.lastma.utils.Mappers.ChallengeServiceMappers.mapChallengeResponse;

public class ChallengeServiceImpl implements  ChallengeService {
    private ChallengeRepository challengeRepository =  new ChallengeRepositoryImpl();
    @Override
    public SubmitChallengeResponse submitChallenge(SubmitChallengeRequest request) {
        Challenge savedChallenge = challengeRepository.save(mapChallengeRequest(request));
        return mapChallengeResponse(savedChallenge);
    }
}
