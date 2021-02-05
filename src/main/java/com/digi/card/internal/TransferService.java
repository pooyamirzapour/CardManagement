package com.digi.card.internal;

import com.digi.card.repository.entity.Request;

public interface TransferService {

    String transfer(Request request) throws Exception;
} 
