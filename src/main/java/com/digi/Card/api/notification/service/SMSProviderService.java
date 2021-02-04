package com.digi.Card.api.notification.service;


import com.digi.Card.api.notification.domain.SMSProviderRequest;

public interface SMSProviderService {

     void notify(SMSProviderRequest smsProviderRequest);
} 
