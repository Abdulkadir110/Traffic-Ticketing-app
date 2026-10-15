package com.lastma.data.repositories;

import com.lastma.data.models.Officer;

import java.util.ArrayList;
import java.util.List;

public class OfficerRepositoryImpl implements OfficerRepository {
    private int count;
    private List<Officer> officers =  new ArrayList<>();
    private int idCount;

    @Override
    public long count() {
        return count;
    }

    @Override
    public Officer save(Officer officer) {
        officers.add(officer);
        officer.setId(++idCount);
        count++;
        return officer;
    }

    @Override
    public Officer findById(int id) {
        for(Officer officer : officers){
            if(officer.getId() == id){
                return officer;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        Officer foundOfficer = findById(id);
        if(foundOfficer != null){
            officers.remove(foundOfficer);
            count--;
        }
    }
}
