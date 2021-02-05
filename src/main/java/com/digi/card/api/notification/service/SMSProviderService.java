package com.digi.card.api.notification.service;


import com.digi.card.api.notification.domain.SMSProviderRequest;

public interface SMSProviderService {

     void notify(SMSProviderRequest smsProviderRequest);
} 
