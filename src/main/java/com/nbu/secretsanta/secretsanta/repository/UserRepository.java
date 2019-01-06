package com.nbu.secretsanta.secretsanta.repository;

import com.nbu.secretsanta.secretsanta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.Email;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(@Email String email);

    User findByUserId(Long userId);
}
