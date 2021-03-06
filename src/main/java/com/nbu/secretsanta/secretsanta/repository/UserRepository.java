package com.nbu.secretsanta.secretsanta.repository;

import com.nbu.secretsanta.secretsanta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.Email;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(@Email String email);

    User findByUserId(Long userId);
    List<User> findAll();
    List<User> findByIsRegisteredTrue();
    List<User> getAllByNameContaining(String substring);
}
