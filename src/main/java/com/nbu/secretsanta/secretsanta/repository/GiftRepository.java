package com.nbu.secretsanta.secretsanta.repository;

import com.nbu.secretsanta.secretsanta.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftRepository extends JpaRepository<Gift, Long> {
    @Override
    Gift getOne(Long aLong);




}
