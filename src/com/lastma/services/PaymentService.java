package com.lastma.services;

import com.lastma.dtos.reponses.PaymentCompletedResponse;
import com.lastma.dtos.requests.MakePaymentRequest;

public interface PaymentService {
    PaymentCompletedResponse makePayment(MakePaymentRequest request);
}
