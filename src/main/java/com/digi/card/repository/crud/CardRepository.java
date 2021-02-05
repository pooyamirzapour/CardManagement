package com.digi.card.repository.crud;

import com.digi.card.repository.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {

    List<Card> findByPan(String pan);
    List<Card> findByCellPhone(String cellPhone);

} 
