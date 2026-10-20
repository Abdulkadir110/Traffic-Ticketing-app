package com.lastma.services;

import com.lastma.data.models.Payment;
import com.lastma.data.repositories.PaymentRepository;
import com.lastma.data.repositories.PaymentRepositoryImpl;
import com.lastma.dtos.reponses.PaymentCompletedResponse;
import com.lastma.dtos.requests.MakePaymentRequest;

import static com.lastma.utils.Mappers.PaymentServiceMappers.mapPaymentRequest;
import static com.lastma.utils.Mappers.PaymentServiceMappers.mapPaymentResponse;

public class PaymentServiceImpl implements PaymentService {
    private PaymentRepository paymentRepository = new PaymentRepositoryImpl();
    @Override
    public PaymentCompletedResponse makePayment(MakePaymentRequest request) {
        Payment payment = paymentRepository.save(mapPaymentRequest(request));
        return mapPaymentResponse(payment);
    }
}
