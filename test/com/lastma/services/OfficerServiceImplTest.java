package com.lastma.services;


import com.lastma.data.models.Driver;
import com.lastma.data.models.ViolationType;
import com.lastma.data.repositories.DriverRepository;
import com.lastma.data.repositories.DriverRepositoryImpl;
import com.lastma.data.repositories.OfficerRepository;
import com.lastma.data.repositories.OfficerRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficerServiceImplTest {
    private OfficerRepository officerRepository = new OfficerRepositoryImpl();
    private DriverRepository driverRepository = new DriverRepositoryImpl();
    private OfficerService officerService;
    @BeforeEach
    public void setUp() {
        officerService = new OfficerServiceImpl();
        officerRepository.deleteAll();
        driverRepository.deleteAll();
    }
    @Test
    public void registerOfficer_officerCountIsOne() {
        assertEquals(0L, officerRepository.count());
        officerService.register("full name", "email", "password");
        assertEquals(1L, officerRepository.count());
    }
    @Test
    public void registerTwoOfficers_officerCountIsTwo() {
        assertEquals(0L, officerRepository.count());
        officerService.register("Abdulkadir", "sem@gmail.com", "aw1234hy");
        officerService.register("Opeyemi", "bem23@gmail.com", "aw1234hy");
        assertEquals(2L, officerRepository.count());
    }
    @Test
    public void registerOfficer_IssueTicketForDriver() {
        officerService.register("Abdulkadir", "sem@gmail.com", "aw1234hy");
        Driver driver = new Driver();
        driver.setCarPlateNumber("LRN5423A4");
        driver.setFullName("Opeyemi");
        driver.setEmail("ope@gmail.com");
        officerService.issueTicket(1,ViolationType.EXPIRED_PAPERS,driver);
        assertEquals(1, driver.getTickets().size());
        assertEquals(1L, driverRepository.count());
    }
    @Test
    public void officerNotRegistered_issueTicketForDriverWithInvalidOfficerId_throwsException() {
        Driver driver = new Driver();
        driver.setCarPlateNumber("LRN5423A4");
        driver.setFullName("Opeyemi");
        driver.setEmail("ope@gmail.com");
        assertThrows(IllegalArgumentException.class, ()-> officerService.issueTicket(1,ViolationType.EXPIRED_PAPERS,driver));
        assertEquals(0, driver.getTickets().size());
        assertEquals(0L, driverRepository.count());
    }
    @Test
    public void registerOfficer_issueTicketForDriver_ViewDriversTickets() {
        officerService.register("Abdulkadir", "sem@gmail.com", "aw1234hy");
        Driver driver = new Driver();
        driver.setCarPlateNumber("LRN5423A4");
        driver.setFullName("Opeyemi");
        driver.setEmail("ope@gmail.com");
        officerService.issueTicket(1,ViolationType.DUI,driver);
        assertEquals(1, driver.getTickets().size());
        assertEquals(1L, driverRepository.count());
        assertEquals(officerService.viewDriverTicket(driver.getId()).size(), 1);
    }
}