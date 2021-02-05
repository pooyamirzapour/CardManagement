package com.digi.card.api.payment.adapter;

import com.digi.card.api.payment.domain.PaymentProvider1Request;
import com.digi.card.api.payment.domain.PaymentProvider2Request;
import com.digi.card.repository.entity.Request;


public class Converter {

    public static PaymentProvider1Request toProvider1DTO(Request request)
    {
        PaymentProvider1Request paymentProvider1Request = new PaymentProvider1Request();
        paymentProvider1Request.setAmount(request.getAmount());
        paymentProvider1Request.setCvv2(request.getCvv());
        paymentProvider1Request.setExpDate(request.getExpDate());
        paymentProvider1Request.setDest(request.getDestination());
        paymentProvider1Request.setSource(request.getSource());
        return paymentProvider1Request;
    }

    public static PaymentProvider2Request toProvider2DTO(Request request)
    {
        PaymentProvider2Request paymentProvider2Request = new PaymentProvider2Request();
        paymentProvider2Request.setAmount(request.getAmount());
        paymentProvider2Request.setCvv2(request.getCvv());
        paymentProvider2Request.setExpire(request.getExpDate());
        paymentProvider2Request.setTarget(request.getDestination());
        paymentProvider2Request.setSource(request.getSource());
        return paymentProvider2Request;
    }
} 
