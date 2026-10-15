package com.lastma.data.repositories;

import com.lastma.data.models.Officer;

public interface OfficerRepository {
    long count();

    Officer save(Officer officer);

    Officer findById(int id);

    void deleteById(int id);
}

