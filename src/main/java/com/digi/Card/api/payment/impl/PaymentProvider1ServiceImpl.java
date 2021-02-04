package com.digi.Card.api.payment.impl;

import com.digi.Card.api.payment.domain.PaymentProvider1Request;
import com.digi.Card.api.payment.service.PaymentProvider1Service;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class PaymentProvider1ServiceImpl implements PaymentProvider1Service {

    public String pay(PaymentProvider1Request paymentProvider1Request) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://first-payment-provider/payments/transfer";


        HttpEntity<PaymentProvider1Request> request = new HttpEntity<PaymentProvider1Request>(paymentProvider1Request);
        Map map = restTemplate.postForObject(url, request, Map.class);
        return null;
    }


}
