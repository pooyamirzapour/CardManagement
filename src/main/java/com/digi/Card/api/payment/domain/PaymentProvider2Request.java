package com.digi.Card.api.payment.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentProvider2Request {
    @JsonProperty("source")
    private String source;
    @JsonProperty("target")
    private String target;
    @JsonProperty("cvv2")
    private String cvv2;
    @JsonProperty("expire")
    private String expire;
    @JsonProperty("pin2")
    private String pin2;
    @JsonProperty("amount")
    private Long amount;


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getPin2() {
        return pin2;
    }

    public void setPin2(String pin2) {
        this.pin2 = pin2;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
