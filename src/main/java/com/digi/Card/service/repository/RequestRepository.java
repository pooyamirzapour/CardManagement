package com.digi.Card.service.repository;

import com.digi.Card.service.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request,Long> {

}
