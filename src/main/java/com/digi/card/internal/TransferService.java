package com.digi.card.internal;

import com.digi.card.repository.entity.TransferRequest;
import com.digi.card.repository.entity.TransferResponse;

public interface TransferService {

    TransferResponse transfer(TransferRequest transferRequest) throws Exception;
} 
