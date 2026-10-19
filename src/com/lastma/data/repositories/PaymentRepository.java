package com.lastma.data.repositories;

import com.lastma.data.models.Payment;

import java.util.List;

public interface PaymentRepository {
    long count();
    Payment save(Payment payment);
    Payment findById(int id);
    void deleteById(int id);
    void deleteAll();
    List<Payment> findAll();
    boolean existsById(int id);
}
