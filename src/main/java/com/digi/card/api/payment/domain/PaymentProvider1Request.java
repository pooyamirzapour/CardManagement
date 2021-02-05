package com.digi.card.api.payment.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentProvider1Request {

    @JsonProperty("source")
    private String source;
    @JsonProperty("dest")
    private String dest;
    @JsonProperty("cvv2")
    private String cvv2;
    @JsonProperty("expDate")
    private String expDate;
    @JsonProperty("pin")
    private String pin;
    @JsonProperty("amount")
    private Long amount;


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}

