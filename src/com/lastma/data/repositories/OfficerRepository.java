package com.lastma.data.repositories;

import com.lastma.data.models.Officer;

public interface OfficerRepository {
    long count();

    void save(Officer officer);
}

