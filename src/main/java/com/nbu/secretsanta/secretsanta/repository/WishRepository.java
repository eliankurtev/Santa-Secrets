package com.nbu.secretsanta.secretsanta.repository;

import com.nbu.secretsanta.secretsanta.model.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishRepository extends JpaRepository<Wish, Long> {
    @Override
    Wish getOne(Long aLong);
}
