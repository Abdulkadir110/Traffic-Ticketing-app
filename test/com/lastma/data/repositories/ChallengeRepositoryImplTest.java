package com.lastma.data.repositories;

import com.lastma.data.models.Challenge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeRepositoryImplTest {

    private ChallengeRepositoryImpl challengeRepository;
    private Challenge challenge;
    @BeforeEach
    public void setUp() {
        challengeRepository = new ChallengeRepositoryImpl();
        challengeRepository.deleteAll();
        challenge = new Challenge();
    }

    @Test
    public void saveChallenge_challengeRepositoryCount_isOne() {
        assertEquals(0L, challengeRepository.count());
        challenge.setReason("reason");
        challengeRepository.save(challenge);
        assertEquals(1L, challengeRepository.count());
    }
    @Test
    public void saveTwoChallenges_challengeRepositoryCount_isTwo() {
        assertEquals(0L, challengeRepository.count());
        challenge.setReason("reason");
        challengeRepository.save(challenge);
        Challenge challenge2 = new Challenge();
        challenge.setReason("reason2");
        challengeRepository.save(challenge2);
        assertEquals(2L, challengeRepository.count());
    }

    @Test
    public void save_nullChallenge_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> challengeRepository.save(null));
    }
    @Test
    public void challengeSaved_canBeUpdated() {
        challenge.setReason("reason");
        challengeRepository.save(challenge);
        challenge.setReason("reason2");
        challengeRepository.save(challenge);

        assertEquals(1L, challengeRepository.count());
    }

    @Test
    public void challengeSaved_updatingANonSavedChallenge_countIsOne() {
        challenge.setReason("reason");
        challengeRepository.save(challenge);
        Challenge challenge2 = new Challenge();
        challenge2.setReason("reason2");
        assertEquals(1L, challengeRepository.count());
    }
    @Test
    public void saveTwoChallenges_findChallengeById() {
        assertEquals(0L, challengeRepository.count());
        challenge.setReason("reason");
        Challenge savedChallenge = challengeRepository.save(challenge);
        Challenge challenge2 = new Challenge();
        challenge.setReason("reason");
        challengeRepository.save(challenge2);
        Challenge foundChallenge = challengeRepository.findById(1);
        assertSame(savedChallenge, foundChallenge);
    }
    @Test
    public void findNonExistingChallengeById() {
        assertEquals(0L, challengeRepository.count());
        assertNull(challengeRepository.findById(1));
    }
    @Test
    public void saveChallenge_checkIfChallengeExistsById() {
        assertEquals(0L, challengeRepository.count());
        challenge.setReason("reason");
        challengeRepository.save(challenge);
        assertTrue(challengeRepository.existsById(1));
    }

    @Test
    public void saveChallenge_checkIfChallengeExistsByNonExistingId() {
        challenge.setReason("reason");
        challengeRepository.save(challenge);
        assertFalse(challengeRepository.existsById(2));
    }

    @Test
    public void saveTwoChallenges_findTheTwoChallenges() {
        challenge.setReason("reason");
        challengeRepository.save(challenge);
        Challenge challenge2 = new Challenge();
        challenge.setReason("reason2");
        challengeRepository.save(challenge2);
        assertEquals(2L, challengeRepository.count());
        assertEquals(2, challengeRepository.findAll().size());
    }

    @Test
    public void saveTwoChallenges_deleteOneChallenge() {
        Challenge challenge = new Challenge();
        challenge.setReason("reason");
        challengeRepository.save(challenge);
        Challenge challenge2 = new Challenge();
        challenge.setReason("reason2");
        challengeRepository.save(challenge2);
        challengeRepository.deleteById(2);
        assertEquals(1L, challengeRepository.count());
    }
}