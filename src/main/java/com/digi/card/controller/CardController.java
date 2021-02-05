package com.digi.card.controller;

import com.digi.card.repository.entity.Card;
import com.digi.card.repository.entity.Request;
import com.digi.card.repository.entity.Response;
import com.digi.card.usecase.service.CardFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Component
public class CardController {

    @Autowired
    CardFacade cardFacade;

    @PostMapping("/cards")
    public ResponseEntity<Card> addCard(@Valid @RequestBody Card card) throws Exception {
        Card addedCard = cardFacade.add(card);
        return new ResponseEntity<>(addedCard, HttpStatus.OK);
    }

    @PutMapping("/cards/{pan}")
    public ResponseEntity<String> removeCard(@PathVariable(value = "pan") String pan) throws Exception {
        cardFacade.remove(pan);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/cards/{pan}")
    public ResponseEntity<List<Card>> viewCards(@PathVariable(value = "String") String pan) throws Exception {
        List<Card> cards = cardFacade.viewList(pan);
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> addCard(@Valid @RequestBody Request request) throws Exception {
        Response response = cardFacade.transfer(request);
        return ResponseEntity.ok(response.getStatus());
    }
}
