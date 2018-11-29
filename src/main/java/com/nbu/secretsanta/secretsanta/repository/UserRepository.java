package com.nbu.secretsanta.secretsanta.repository;

import com.nbu.secretsanta.secretsanta.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
