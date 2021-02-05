package com.digi.card.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class RestClientServiceImpl implements RestClientService {
    @Override
    public HttpStatus doPost(Map map, String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.postForEntity(url, map, Void.class);
        return response.getStatusCode();
    }
}
