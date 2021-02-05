package com.digi.card.repository.crud;

import com.digi.card.repository.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card,Long> {

    List<Card> findByPan(String pan);
    List<Card> findByCellPhone(String cellPhone);

} 
