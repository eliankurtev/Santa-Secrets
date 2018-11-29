package com.nbu.secretsanta.secretsanta.service;


import com.nbu.secretsanta.secretsanta.model.User;

public interface UserService {
    boolean validate(User user);
    void save(User user);
}
