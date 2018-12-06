package com.nbu.secretsanta.secretsanta.service.interfaces;


import com.nbu.secretsanta.secretsanta.model.User;

import javax.validation.constraints.Email;

public interface UserService {
    boolean validate(User user);
    void save(User user);
    User getUserByEmail(@Email String i);
}
