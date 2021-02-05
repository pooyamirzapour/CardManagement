package com.digi.card.internal;

import com.digi.card.repository.entity.Card;
import com.digi.card.repository.entity.TransferRequest;
import com.digi.card.repository.entity.TransferResponse;

import java.util.List;

public interface CardService {
    Card add(Card card) throws Exception;
    void remove(String pan) throws Exception;
    List<Card> viewList(String cellPhone) throws Exception;
    TransferResponse transfer(TransferRequest transferRequest) throws Exception;

} 
