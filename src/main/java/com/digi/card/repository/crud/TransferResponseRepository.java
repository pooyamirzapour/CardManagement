package com.digi.card.repository.crud;

import com.digi.card.repository.entity.TransferResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferResponseRepository extends   JpaRepository <TransferResponse, Long> {

}
