package com.digi.card.internal;

import com.digi.card.repository.entity.Request;
import com.digi.card.repository.entity.Response;

public interface TransferService {

    Response transfer(Request request) throws Exception;
} 
