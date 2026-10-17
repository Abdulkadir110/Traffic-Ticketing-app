package com.lastma.data.repositories;

import com.lastma.data.models.Driver;
import com.lastma.data.models.Officer;
import com.lastma.data.models.Officer;

import java.util.ArrayList;
import java.util.List;

public class OfficerRepositoryImpl implements OfficerRepository {
    private int idcount;
    private List<Officer> officers = new ArrayList<>();
    @Override
    public long count() {
        return officers.size();
    }

    @Override
    public Officer save(Officer officer) {
        if (existsById(officer.getId())) {
            update(officer);
            return officer;
        }
        officer.setId(++idcount);
        officers.add(officer);
        return officer;
    }

    @Override
    public Officer findById(int id) {
        return findOfficer(id);
    }

    @Override
    public void deleteById(int id) {
        Officer foundOfficer = findOfficer(id);
        officers.remove(foundOfficer);
    }

    @Override
    public void deleteAll() {
        officers.clear();
    }

    @Override
    public List<Officer> findAll() {
        return List.copyOf(officers);
    }

    @Override
    public boolean existsById(int id) {
        Officer foundOfficer = findById(id);
        return foundOfficer != null;
    }

    private Officer findOfficer(int id){
        for(Officer officer : officers){
            if(officer.getId() == id){
                return officer;
            }
        }
        return null;
    }
    private Officer findOfficer(Officer Officer){
        for(Officer eachOfficer : officers){
            if(Officer.equals(eachOfficer)){
                return eachOfficer;
            }
        }
        return null;
    }
    private void validate(Officer Officer){
        if(Officer == null) throw new IllegalArgumentException("The entity is null");
    }
    private void update(Officer officer) {
        Officer  foundOfficer = findOfficer(officer);
        if(foundOfficer != null && foundOfficer.getId() == officer.getId()){
            officers.set(officers.indexOf(officer), officer);
        }
    }
}
