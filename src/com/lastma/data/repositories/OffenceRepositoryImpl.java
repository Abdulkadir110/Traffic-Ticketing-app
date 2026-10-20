package com.lastma.data.repositories;


import com.lastma.data.models.Offence;

import java.util.ArrayList;
import java.util.List;

public class OffenceRepositoryImpl implements OffenceRepository {
    private int idcount;
    private static List<Offence> offences = new ArrayList<>();
    @Override
    public long count() {
        return offences.size();
    }

    @Override
    public Offence save(Offence offence) {
        if(offence == null) return null;
        if (existsById(offence.getId())) {
            update(offence);
            return offence;
        }
        offence.setId(++idcount);
        offence.setActive(true);
        offences.add(offence);
        return offence;
    }

    @Override
    public Offence findById(int id) {
        return findOffence(id);
    }

    @Override
    public void deleteById(int id) {
        Offence offence = findOffence(id);
        offences.remove(offence);
    }

    @Override
    public void deleteAll() {
        offences.clear();
    }

    @Override
    public List<Offence> findAll() {
        return List.copyOf(offences);
    }

    @Override
    public boolean existsById(int id) {
        Offence foundOffence = findById(id);
        return foundOffence != null;
    }

    private Offence findOffence(int id){
        for(Offence offence : offences){
            if(offence.getId() == id){
                return offence;
            }
        }
        return null;
    }
    private void update(Offence offence) {
        offences.set(offences.indexOf(offence), offence);
    }
}
