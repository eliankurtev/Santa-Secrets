package com.nbu.secretsanta.secretsanta.service.interfaces;


import com.nbu.secretsanta.secretsanta.model.User;

import javax.validation.constraints.Email;
import java.util.List;

public interface UserService {

    boolean validate(User user);

    void save(User user);

    User getUserByEmail(@Email String i);

    long uCount(); // uCount -> Total Users Count/

    int ruCount(); // ruCount -> Registered Users Count/

    List<String> ruNamesList(); // ruNamesList -> Registered Users Names List/
}
