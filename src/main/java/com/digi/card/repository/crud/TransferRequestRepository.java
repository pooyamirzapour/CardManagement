package com.digi.card.repository.crud;

import com.digi.card.repository.entity.TransferRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRequestRepository extends JpaRepository<TransferRequest,Long> {

}
