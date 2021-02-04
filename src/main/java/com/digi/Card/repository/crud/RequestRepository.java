package com.digi.Card.repository.crud;

import com.digi.Card.repository.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request,Long> {

}
