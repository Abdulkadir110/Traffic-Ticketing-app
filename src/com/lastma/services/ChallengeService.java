package com.lastma.services;


import com.lastma.dtos.reponses.SubmitChallengeResponse;
import com.lastma.dtos.requests.SubmitChallengeRequest;

public interface ChallengeService {
    SubmitChallengeResponse submitChallenge(SubmitChallengeRequest request);
}
