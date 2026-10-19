package com.lastma.data.repositories;

import com.lastma.data.models.Challenge;

import java.util.ArrayList;
import java.util.List;

public class ChallengeRepositoryImpl implements  ChallengeRepository {
    private int idcount;
    private static List<Challenge> challenges = new ArrayList<>();

    @Override
    public long count() {
        return challenges.size();
    }

    @Override
    public Challenge save(Challenge challenge) {
        validate(challenge);

        if (existsById(challenge.getId())) {
            update(challenge);
            return challenge;
        }

        challenge.setId(++idcount);
        challenges.add(challenge);

        return challenge;
    }

    @Override
    public Challenge findById(int id) {
        return findChallenge(id);
    }

    @Override
    public void deleteById(int id) {
        Challenge challenge = findChallenge(id);
        challenges.remove(challenge);
    }

    @Override
    public void deleteAll() {
        challenges.clear();
    }

    @Override
    public List<Challenge> findAll() {
        return List.copyOf(challenges);
    }

    @Override
    public boolean existsById(int id) {
        Challenge foundChallenge = findById(id);
        return foundChallenge != null;
    }

    private Challenge findChallenge(int id) {
        for (Challenge challenge : challenges) {
            if (challenge.getId() == id) {
                return challenge;
            }
        }

        return null;
    }

    private void validate(Challenge challenge) {
        if (challenge == null) {
            throw new IllegalArgumentException("The entity is null");
        }
    }

    private void update(Challenge challenge) {
        challenges.set(challenges.indexOf(challenge), challenge);
    }
}
