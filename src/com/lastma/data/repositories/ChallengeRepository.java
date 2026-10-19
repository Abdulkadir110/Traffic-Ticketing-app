package com.lastma.data.repositories;

import com.lastma.data.models.Challenge;

import java.util.List;

public interface ChallengeRepository {
    long count();
    Challenge save(Challenge challenge);
    Challenge findById(int id);
    void deleteById(int id);
    void deleteAll();
    List<Challenge> findAll();
    boolean existsById(int id);
}
