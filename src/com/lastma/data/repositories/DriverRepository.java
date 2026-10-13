package com.lastma.data.repositories;

import com.lastma.data.models.Driver;

public interface DriverRepository {
    long count();
    Driver save(Driver driver);
    Driver findById(int id);
    Driver update(Driver driver);

    void delete(Driver driver);
}
