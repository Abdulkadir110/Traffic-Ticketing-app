package com.lastma.data.repositories;

import com.lastma.data.models.Officer;

public class OfficerRepositoryImpl implements OfficerRepository {
    private int count;

    @Override
    public long count() {
        return count;
    }

    @Override
    public void save(Officer officer) {
        count++;
    }
}
