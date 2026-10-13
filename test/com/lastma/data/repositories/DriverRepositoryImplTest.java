package com.lastma.data.repositories;

import com.lastma.data.models.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DriverRepositoryImplTest {
    private DriverRepository driverRepository;
    private Driver driver;
    @BeforeEach
    public void startWith(){
        driverRepository = new DriverRepositoryImpl();
        driver = new Driver();
    }
    @Test
    public void save_Driver_count_increase_to_one(){
        assertEquals(0L, driverRepository.count());
        driver.setFullName("Abdulkadir");
        driver.setEmail("johnDoe@gmail.com");
        driverRepository.save(driver);
        assertEquals(1L, driverRepository.count());
    }
    @Test
    public void save_TwoDriver_count_increase_to_two(){
        assertEquals(0L, driverRepository.count());
        driver.setFullName("Abdulkadir");
        driver.setEmail("johnDoe@gmail.com");
        driverRepository.save(driver);
        assertEquals(1L, driverRepository.count());
        Driver driverTwo = new Driver();
        driverTwo.setFullName("Opeyemi");
        driverTwo.setEmail("Doe@gmail.com");
        driverRepository.save(driverTwo);
        assertEquals(2L, driverRepository.count());
    }
    @Test
    public void save_aDriver_andAn_Id_wasGenerated_forTheEntity(){
        assertEquals(0L, driverRepository.count());
        driver.setFullName("Abdulkadir");
        driver.setEmail("johnDoe@gmail.com");
        driverRepository.save(driver);
        assertEquals(driver.getId(), driverRepository.count());
    }
    @Test
    public void saveDriver_FindById_getSavedDriver(){
        driver.setFullName("Abdulkadir");
        driver.setEmail("johnDoe@gmail.com");
        Driver savedDriver = driverRepository.save(driver);
        assertEquals(1L, driverRepository.count());
        assertEquals(savedDriver, driverRepository.findById(1));
    }
    @Test
    public void saveTwoDrivers_FindFirstDriverById(){
        driver.setFullName("Abdulkadir");
        driver.setEmail("johnDoe@gmail.com");
        Driver driverTwo = new Driver();
        driverTwo.setFullName("Opeyemi");
        driverTwo.setEmail("DoeJohn@gmail.com");
        Driver savedDriver = driverRepository.save(driver);
        driverRepository.save(driverTwo);
        assertEquals(2L, driverRepository.count());
        Driver foundDriver = driverRepository.findById(1);
        assertEquals(savedDriver, foundDriver);
    }
    @Test
    public void saveDriver_thenUpdateDriver(){
        driver.setFullName("Abdulkadir");
        driver.setEmail("johnDoe@gmail.com");
        Driver savedDriver = driverRepository.save(driver);
        assertEquals(1L, driverRepository.count());
        driver.setFullName("Opeyemi");
        driver.setEmail("blackDoe@gmail.com");
        driver.setCarPlateNumber("LRN563A5");
        Driver updatedDriver = driverRepository.update(driver);
        assertEquals(1L, driverRepository.count());
        assertSame(savedDriver, updatedDriver);
        assertEquals(savedDriver.getFullName(), updatedDriver.getFullName());
    }
    @Test
    public void saveTwoDrivers_DeleteOne(){
        driver.setFullName("Abdulkadir");
        driver.setEmail("johnDoe@gmail.com");
        Driver driverTwo = new Driver();
        driverTwo.setFullName("Opeyemi");
        driverTwo.setEmail("DoeJohn@gmail.com");
        driverRepository.save(driver);
        driverRepository.save(driverTwo);
        assertEquals(2L, driverRepository.count());
        driverRepository.delete(driver);
        assertEquals(1L, driverRepository.count());
    }
    @Test
    public void saveThreeDrivers_DeleteFirstOne_FindSecondOneById(){
        driver.setFullName("Abdulkadir");
        driver.setEmail("johnDoe@gmail.com");
        Driver driverTwo = new Driver();
        driverTwo.setFullName("Opeyemi");
        driverTwo.setEmail("DoeJohn@gmail.com");
        Driver driverThree = new Driver();
        driver.setFullName("Zakariyah");
        driver.setEmail("zaks@gmail.com");
        driverRepository.save(driver);
        Driver savedDriver2 = driverRepository.save(driverTwo);
        driverRepository.save(driverThree);
        assertEquals(3L, driverRepository.count());
        driverRepository.delete(driver);
        Driver foundDriver = driverRepository.findById(2);
        assertEquals(savedDriver2, foundDriver);
        assertEquals(2L, driverRepository.count());
    }
    @Test
    public void saveA_null_throwsException(){
        assertThrows(IllegalArgumentException.class,()->driverRepository.save(null));
    }
    @Test
    public void find_an_Entity_with_WrongId_Null_Entity(){
        assertNull(driverRepository.findById(1));
    }
}