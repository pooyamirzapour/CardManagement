package com.digi.card.repository.crud;

import com.digi.card.repository.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends   JpaRepository <Response, Long> {

}
