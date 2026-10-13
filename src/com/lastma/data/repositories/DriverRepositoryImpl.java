package com.lastma.data.repositories;

import com.lastma.data.models.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverRepositoryImpl implements DriverRepository{
    private int count;
    private List<Driver> drivers = new ArrayList<>();
    @Override
    public long count() {
        return count;
    }

    @Override
    public Driver save(Driver driver) {
        validate(driver);
        driver.setId(++count);
        drivers.add(driver);
        return driver;
    }

    @Override
    public Driver findById(int id) {
        return findDriver(id);
    }

    @Override
    public Driver update(Driver driver) {
        validate(driver);
        Driver foundDriver = findDriver(driver);
        foundDriver = driver;
        return foundDriver;
    }

    @Override
    public void delete(Driver driver) {
        Driver foundDriver = findDriver(driver);
        drivers.remove(foundDriver);
        count--;
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
}
