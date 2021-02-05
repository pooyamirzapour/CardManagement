package com.digi.card.repository.crud;

import com.digi.card.repository.entity.NotificationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRequestRepository extends JpaRepository<NotificationRequest,Long> {
} 
