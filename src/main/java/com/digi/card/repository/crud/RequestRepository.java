package com.digi.card.repository.crud;

import com.digi.card.repository.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request,Long> {

}
