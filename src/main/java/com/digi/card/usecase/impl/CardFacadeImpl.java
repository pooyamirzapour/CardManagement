package com.digi.card.usecase.impl;

import com.digi.card.internal.CardService;
import com.digi.card.repository.entity.Card;
import com.digi.card.repository.entity.TransferRequest;
import com.digi.card.repository.entity.TransferResponse;
import com.digi.card.usecase.service.CardFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardFacadeImpl implements CardFacade {
    @Autowired
    CardService cardService;

    @Override
    public Card add(Card card) throws Exception {
       return cardService.add(card);
    }

    @Override
    public void remove(String pan) throws Exception {
        cardService.remove(pan);

    }

    @Override
    public TransferResponse transfer(TransferRequest transferRequest) throws Exception {
       return cardService.transfer(transferRequest);
    }

    @Override
    public List<Card> viewList(String cellPhone) throws Exception {
       return cardService.viewList(cellPhone);
    }
}
