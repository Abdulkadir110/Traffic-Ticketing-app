package com.lastma.data.repositories;

import com.lastma.data.models.Officer;

import java.util.List;

public interface OfficerRepository {
    long count();

    Officer save(Officer officer);

    Officer findById(int id);

    void deleteById(int id);
    void deleteAll();
    List<Officer> findAll();
    boolean existsById(int id);
}

