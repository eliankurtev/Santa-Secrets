package com.nbu.secretsanta.secretsanta.service.classes;

import com.nbu.secretsanta.secretsanta.model.User;
import com.nbu.secretsanta.secretsanta.repository.UserRepository;
import com.nbu.secretsanta.secretsanta.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean validate(User user) {
        return false;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserByEmail(@Email String i) {
        return userRepository.findByEmail(i);
    }

    @Override // uCount -> Total Users Count
    public long uCount() {
        long count;
        count = userRepository.count();
        return count;
    }

    @Override // Registered Users Count
    public int ruCount() {
        int count = 0;
        List<User> users = new ArrayList<>();
        users = userRepository.findAll();
        for (User user : users) {
            if(user.getIsRegistered()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public List<String> ruNamesList() { // ruNamesList -> Registered Users Names List/
        List<String> userNames = new ArrayList<>();
        List<User> users;
        users = userRepository.findAll();
        String temp;
        for (User user : users) {
            temp = user.getName();
            userNames.add(temp);
        }
        return userNames;
    }
}
