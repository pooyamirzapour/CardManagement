package com.digi.card.api.payment.adapter;

import com.digi.card.api.payment.domain.PaymentProvider1Request;
import com.digi.card.api.payment.domain.PaymentProvider2Request;
import com.digi.card.repository.entity.TransferRequest;


public class Converter {

    public static PaymentProvider1Request toProvider1DTO(TransferRequest transferRequest)
    {
        PaymentProvider1Request paymentProvider1Request = new PaymentProvider1Request();
        paymentProvider1Request.setAmount(transferRequest.getAmount());
        paymentProvider1Request.setCvv2(transferRequest.getCvv());
        paymentProvider1Request.setExpDate(transferRequest.getExpDate());
        paymentProvider1Request.setDest(transferRequest.getDestination());
        paymentProvider1Request.setSource(transferRequest.getSource());
        return paymentProvider1Request;
    }

    public static PaymentProvider2Request toProvider2DTO(TransferRequest transferRequest)
    {
        PaymentProvider2Request paymentProvider2Request = new PaymentProvider2Request();
        paymentProvider2Request.setAmount(transferRequest.getAmount());
        paymentProvider2Request.setCvv2(transferRequest.getCvv());
        paymentProvider2Request.setExpire(transferRequest.getExpDate());
        paymentProvider2Request.setTarget(transferRequest.getDestination());
        paymentProvider2Request.setSource(transferRequest.getSource());
        return paymentProvider2Request;
    }
} 
