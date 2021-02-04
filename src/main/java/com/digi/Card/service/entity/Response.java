package com.digi.Card.service.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Response")
public class Response {
    private long id;
    private String name;
} 
