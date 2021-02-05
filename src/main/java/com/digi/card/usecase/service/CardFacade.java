package com.digi.card.usecase.service;

import com.digi.card.repository.entity.Card;
import com.digi.card.repository.entity.Request;
import com.digi.card.repository.entity.Response;

import java.util.List;

public interface CardFacade {
   Card add(Card card) throws Exception;
   void remove(String pan) throws Exception;
   Response transfer(Request request) throws Exception;
   List<Card> viewList(String cellPhone) throws Exception;
}
