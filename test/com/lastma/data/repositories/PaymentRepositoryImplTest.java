package com.lastma.data.repositories;

import com.lastma.data.models.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentRepositoryImplTest {

    private PaymentRepositoryImpl paymentRepository;
    private Payment payment;
    @BeforeEach
    public void setUp() {
        paymentRepository = new PaymentRepositoryImpl();
        paymentRepository.deleteAll();
        payment = new Payment();
    }

    @Test
    public void savePayment_paymentRepositoryCount_isOne() {
        assertEquals(0L, paymentRepository.count());
        payment.setAmount(5_000);
        paymentRepository.save(payment);
        assertEquals(1L, paymentRepository.count());
    }
    @Test
    public void saveTwoPayments_paymentRepositoryCount_isTwo() {
        assertEquals(0L, paymentRepository.count());
        payment.setAmount(5_000);
        paymentRepository.save(payment);
        Payment payment2 = new Payment();
        paymentRepository.save(payment2);
        assertEquals(2L, paymentRepository.count());
    }
    @Test
    public void saveNullObject_paymentRepositoryCount_isZero() {
        paymentRepository.save(null);
        assertEquals(0L, paymentRepository.count());
    }
    @Test
    public void paymentSaved_canBeUpdated() {
        payment.setAmount(5_000);
        paymentRepository.save(payment);
        payment.setAmount(9_000);
        paymentRepository.save(payment);
        assertEquals(1L, paymentRepository.count());
    }
    @Test
    public void saveTwoPayments_findPaymentById() {
        payment.setAmount(5_000);
        Payment savedPayment = paymentRepository.save(payment);
        payment.setAmount(9_000);
        Payment payment2 = new Payment();
        payment.setAmount(9_000);
        paymentRepository.save(payment2);
        Payment foundPayment = paymentRepository.findById(1);
        assertSame(savedPayment, foundPayment);
    }
    @Test
    public void findNonExistingPaymentById() {
        assertEquals(0L, paymentRepository.count());
        assertNull(paymentRepository.findById(1));
    }
    @Test
    public void savePayment_checkIfPaymentExistsById() {
        payment.setAmount(5_000);
        paymentRepository.save(payment);
        assertTrue(paymentRepository.existsById(1));
    }

    @Test
    public void savePayment_checkIfPaymentExistsByNonExistingId() {
        payment.setAmount(5_000);
        paymentRepository.save(payment);
        assertFalse(paymentRepository.existsById(2));
    }
    @Test
    public void saveTwoPayments_findTheTwoPayments() {
        payment.setAmount(5_000);
        paymentRepository.save(payment);
        Payment payment2 = new Payment();
        payment.setAmount(9_000);
        paymentRepository.save(payment2);
        assertEquals(2L, paymentRepository.count());
        assertEquals(2, paymentRepository.findAll().size());
    }
    @Test
    public void saveTwoPayments_deleteOnePayment() {
        payment.setAmount(5_000);
        paymentRepository.save(payment);
        Payment payment2 = new Payment();
        payment.setAmount(9_000);
        paymentRepository.save(payment2);
        paymentRepository.deleteById(2);
        assertEquals(1L, paymentRepository.count());
    }
    @Test
    public void deleteAllPayments_paymentRepositoryCount_isZero() {
        payment.setAmount(5_000);
        paymentRepository.save(payment);
        Payment payment2 = new Payment();
        payment.setAmount(9_000);
        paymentRepository.save(payment2);
        paymentRepository.deleteAll();
        assertEquals(0L, paymentRepository.count());
    }
}