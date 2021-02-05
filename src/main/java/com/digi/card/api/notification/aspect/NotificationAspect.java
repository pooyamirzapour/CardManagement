package com.digi.card.api.notification.aspect;

import com.digi.card.api.notification.service.NotificationService;
import com.digi.card.api.notification.service.SMSProviderService;
import com.digi.card.internal.CardService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Configuration
@Component
public class NotificationAspect {


    @Around("execution( * com.digi.card.internal.tranferService.*.*(..))&& args(yourString,..)")
    public void aroundAccount(ProceedingJoinPoint proceedingJoinPoint, String  yourString) throws Throwable
    {
        CodeSignature signature = (CodeSignature)proceedingJoinPoint.getSignature();

        Object returnValue = proceedingJoinPoint.proceed();

        if (returnValue.equals("ok"))
            System.out.println("");
        //NotificationService.INSTANCE.sendNotification(joinPoint.);
    }

} 
