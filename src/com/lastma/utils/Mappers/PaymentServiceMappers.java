package com.lastma.utils.Mappers;

import com.lastma.data.models.Payment;
import com.lastma.dtos.reponses.PaymentCompletedResponse;
import com.lastma.dtos.requests.MakePaymentRequest;

public class PaymentServiceMappers {
    public static Payment mapPaymentRequest(MakePaymentRequest request) {
        Payment payment = new Payment();
        payment.setAmount(request.getAmount());
        payment.setPaymentDate(request.getPaymentDate());
        payment.setPaymentReference(request.getPaymentReference());
        payment.setTicketId(request.getTicketId());
        return payment;
    }
    public static PaymentCompletedResponse mapPaymentResponse(Payment payment){
        PaymentCompletedResponse response = new PaymentCompletedResponse();
        response.setId(payment.getId());
        response.setAmount(payment.getAmount());
        response.setPaymentDate(payment.getPaymentDate());
        response.setPaymentReference(payment.getPaymentReference());
        return  response;
    }
}
