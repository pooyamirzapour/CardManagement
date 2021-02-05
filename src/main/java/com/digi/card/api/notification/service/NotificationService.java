package com.digi.card.api.notification.service;

import com.digi.card.repository.crud.NotificationRequestRepository;
import com.digi.card.repository.crud.NotificationResponseRepository;
import com.digi.card.repository.entity.NotificationRequest;
import com.digi.card.repository.entity.NotificationResponse;
import com.digi.card.util.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

public enum NotificationService {
    INSTANCE;

    @Autowired
    RestClientService restClientService;

    @Autowired
    NotificationRequestRepository notificationRequestRepository;

    @Autowired
    NotificationResponseRepository notificationResponseRepository;

    @Transactional
    public void sendNotification(NotificationRequest notificationRequest) {
        NotificationRequest savedRequest = notificationRequestRepository.saveAndFlush(notificationRequest);
        String url = "https://sms-provider/messages/send-sms";
        Map<String, String> map = new HashMap<>();
        map.put("target", notificationRequest.getTarget());
        map.put("msg", notificationRequest.getMsg());
        HttpStatus httpStatus = restClientService.doPost(map, url);
        NotificationResponse notificationResponse = new NotificationResponse();
        notificationResponse.setStatus(Integer.toString(httpStatus.value()));
        notificationResponse.setNotificationRequestId(savedRequest.getId());
        notificationResponseRepository.saveAndFlush(notificationResponse);
    }
} 
