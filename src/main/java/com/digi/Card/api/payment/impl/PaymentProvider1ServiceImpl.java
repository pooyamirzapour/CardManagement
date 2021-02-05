package com.digi.Card.api.payment.impl;

import com.digi.Card.api.payment.domain.PaymentProvider1Request;
import com.digi.Card.api.payment.service.PaymentProvider1Service;
import com.digi.Card.service.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentProvider1ServiceImpl implements PaymentProvider1Service {

    @Autowired
    RestClientService restClientService;


    public String pay(PaymentProvider1Request paymentProvider1Request) {
        doPost(paymentProvider1Request);
        return "";
    }

    private HttpStatus doPost(PaymentProvider1Request paymentProvider1Request) {
        String url = "https://first-payment-provider/payments/transfer";
        Map<String, String> map = new HashMap<>();
        map.put("cvv2", paymentProvider1Request.getCvv2());
        map.put("dest", paymentProvider1Request.getDest());
        map.put("dest", paymentProvider1Request.getSource());
        map.put("pin", paymentProvider1Request.getPin());
        map.put("expDate", paymentProvider1Request.getExpDate());
        map.put("amount", paymentProvider1Request.getAmount().toString());
        return restClientService.doPost(map, url);

    }


}
