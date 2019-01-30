package com.nbu.secretsanta.secretsanta.service.interfaces;


import com.nbu.secretsanta.secretsanta.model.Hobby;
import com.nbu.secretsanta.secretsanta.model.User;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserService {
    boolean validate(User user);
    void save(User user);
    User getUserByEmail(@Email String i);
    User getUserById(long userId);
    List<User> getAllUsers();
    Map<String, Integer> countAllUsers();
    List<User> getAllByNameContaining(String substring);
    void unregUser (User user);
    void changeHobbies(User user, Set<Hobby> hobbyList);
    Set<Hobby> getHobbies(User user);
}
