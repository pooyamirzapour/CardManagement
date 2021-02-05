package com.digi.card.util;

import org.springframework.http.HttpStatus;

import java.util.Map;

public interface RestClientService {
    HttpStatus doPost(Map map,String url);
} 
