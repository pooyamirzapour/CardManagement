package com.digi.Card.service.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Request")
public class Request     {
    private long id;
    private String name;
} 
