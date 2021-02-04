package com.digi.Card.api.notification.domain;

public class SMSProviderRequest {
    private String msg;
    private String target;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
