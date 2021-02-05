package com.digi.card.api.payment.impl;

import com.digi.card.api.payment.domain.PaymentProvider2Request;
import com.digi.card.api.payment.service.PaymentProvider2Service;
import com.digi.card.util.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentProvider2ServiceImp implements PaymentProvider2Service {

    @Autowired
    RestClientService restClientService;




    public String pay(PaymentProvider2Request paymentProvider2Request) {
        HttpStatus httpStatus = doPost(paymentProvider2Request);
        return Integer.toString(httpStatus.value());
    }

    private HttpStatus doPost(PaymentProvider2Request paymentProvider2Request) {
        String url = "https://second-payment-provider/cards/pay";
        Map<String, String> map = new HashMap<>();
        map.put("cvv2", paymentProvider2Request.getCvv2());
        map.put("target", paymentProvider2Request.getTarget());
        map.put("pin2", paymentProvider2Request.getPin2());
        map.put("source", paymentProvider2Request.getSource());
        map.put("expire", paymentProvider2Request.getExpire());
        map.put("amount", paymentProvider2Request.getAmount().toString());
        return restClientService.doPost(map, url);

    }
}
