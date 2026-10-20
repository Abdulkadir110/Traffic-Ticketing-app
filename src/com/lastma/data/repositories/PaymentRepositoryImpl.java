package com.lastma.data.repositories;

import com.lastma.data.models.Payment;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepositoryImpl implements PaymentRepository {

    private int idcount;
    private static List<Payment> payments = new ArrayList<>();

    @Override
    public long count() {
        return payments.size();
    }
    @Override
    public Payment save(Payment payment) {
        if(payment == null) return null;
        if (existsById(payment.getId())) {
            update(payment);
            return payment;
        }
        payment.setId(++idcount);
        payments.add(payment);
        return payment;
    }
    @Override
    public Payment findById(int id) {
        return findPayment(id);
    }
    @Override
    public void deleteById(int id) {
        Payment payment = findPayment(id);
        payments.remove(payment);
    }
    @Override
    public void deleteAll() {
        payments.clear();
    }
    @Override
    public List<Payment> findAll() {
        return List.copyOf(payments);
    }
    @Override
    public boolean existsById(int id) {
        Payment foundPayment = findById(id);
        return foundPayment != null;
    }

    private Payment findPayment(int id) {
        for (Payment payment : payments) {
            if (payment.getId() == id) return payment;
        }
        return null;
    }
    private void update(Payment payment) {
        payments.set(payments.indexOf(payment), payment);
    }
}