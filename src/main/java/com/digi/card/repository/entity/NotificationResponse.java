package com.digi.card.repository.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class NotificationResponse {
    private Long id;
    private String status;
    private Date insertDate;
    private Long notificationRequestId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "insert_date")
    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    @Column(name = "notification_request_id")
    public Long getNotificationRequestId() {
        return notificationRequestId;
    }

    public void setNotificationRequestId(Long notificationRequestId) {
        this.notificationRequestId = notificationRequestId;
    }
}
