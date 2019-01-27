package com.nbu.secretsanta.secretsanta.repository;

import com.nbu.secretsanta.secretsanta.model.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {
    @Override
    Hobby getOne(Long aLong);

}