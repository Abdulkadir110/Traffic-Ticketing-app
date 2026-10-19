package com.lastma.data.repositories;


import com.lastma.data.models.Offence;

import java.util.List;

public interface OffenceRepository {
    long count();
    Offence save(Offence offence);
    Offence findById(int id);
    void deleteById(int id);
    void deleteAll();
    List<Offence> findAll();
    boolean existsById(int id);
}
