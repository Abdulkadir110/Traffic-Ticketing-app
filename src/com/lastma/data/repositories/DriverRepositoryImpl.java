package com.lastma.data.repositories;

import com.lastma.data.models.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverRepositoryImpl implements DriverRepository{
    private int idcount;
    private static List<Driver> drivers = new ArrayList<>();
    @Override
    public long count() {
        return drivers.size();
    }

    @Override
    public Driver save(Driver driver) {
        validate(driver);
        if (existsById(driver.getId())) {
            update(driver);
            return driver;
        }
        driver.setId(++idcount);
        drivers.add(driver);
        return driver;
    }

    @Override
    public Driver findById(int id) {
        return findDriver(id);
    }

    @Override
    public void deleteById(int id) {
        Driver driver = findDriver(id);
        drivers.remove(driver);
    }

    @Override
    public void deleteAll() {
        drivers.clear();
    }

    @Override
    public List<Driver> findAll() {
        return List.copyOf(drivers);
    }

    @Override
    public boolean existsById(int id) {
        Driver foundDriver = findById(id);
        return foundDriver != null;
    }

    private Driver findDriver(int id){
        for(Driver driver : drivers){
            if(driver.getId() == id){
                return driver;
            }
        }
        return null;
    }
    private Driver findDriver(Driver driver){
        for(Driver eachDriver : drivers){
            if(driver.equals(eachDriver)){
                return eachDriver;
            }
        }
        return null;
    }
    private void validate(Driver driver){
        if(driver == null) throw new IllegalArgumentException("The entity is null");
    }
    private void update(Driver driver) {
        drivers.set(drivers.indexOf(driver), driver);
    }
}

