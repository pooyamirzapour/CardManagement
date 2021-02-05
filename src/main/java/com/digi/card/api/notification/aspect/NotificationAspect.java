package com.digi.card.api.notification.aspect;

import com.digi.card.api.notification.service.NotificationService;
import com.digi.card.repository.entity.NotificationRequest;
import com.digi.card.repository.entity.TransferResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Configuration
@Component
public class NotificationAspect {


    @Around("execution( * com.digi.card.internal.tranferService.*.*(..))&& args(yourString,..)")
    public void aroundAccount(ProceedingJoinPoint proceedingJoinPoint, String yourString) throws Throwable {
        CodeSignature signature = (CodeSignature) proceedingJoinPoint.getSignature();
        Object returnValue = proceedingJoinPoint.proceed();
        TransferResponse transferResponse = (TransferResponse) returnValue;
        if (transferResponse.getStatus().equals("200")) {
            NotificationRequest notificationRequest = new NotificationRequest();
            notificationRequest.setTarget(transferResponse.getCellPhone());
            notificationRequest.setTransferResponseId(transferResponse.getId());
            notificationRequest.setMsg("Done");
            NotificationService.INSTANCE.sendNotification(notificationRequest);
        }
    }

} 
