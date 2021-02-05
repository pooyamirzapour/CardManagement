package com.digi.card.internal;

import com.digi.card.repository.crud.CardRepository;
import com.digi.card.repository.entity.Card;
import com.digi.card.repository.entity.Request;
import com.digi.card.repository.enums.CardStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    TransferService transferService;

    @Override
    public Card add(Card card) throws Exception {
        if (isValid(card)) {
            card.setStatus(CardStatus.ACTIVE.getValue());
            return cardRepository.saveAndFlush(card);
        }
        throw new Exception("operation failed");//todo define proper message and specific exception

    }

    private boolean isValid(Card card) throws Exception {
        if (card.getCellPhone() == null || card.getCvv() == null || card.getPan() == null || card.getPin() == null)
            throw new Exception("card is invalid");//todo define proper message and specific exception
        return true;
    }

    @Override
    public void remove(String pan) throws Exception {
        Card loadedCard = load(pan);
        loadedCard.setStatus(CardStatus.INACTIVE.getValue());
        cardRepository.saveAndFlush(loadedCard);
    }

    private Card load(String pan) throws Exception {
        List<Card> cardLoaded = cardRepository.findByPan(pan);
        //todo define proper message and specific exception
        return cardLoaded.stream().findFirst().orElseThrow(() -> new Exception("card not found"));
    }

    @Override
    public List<Card> viewList(String cellPhone) throws Exception {
        return cardRepository.findByCellPhone(cellPhone);
    }

    @Override
    public String transfer(Request request) throws Exception {
       return transferService.transfer(request);
    }
}
