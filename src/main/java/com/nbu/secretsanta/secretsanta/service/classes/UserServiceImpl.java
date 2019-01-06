package com.nbu.secretsanta.secretsanta.service.classes;

import com.nbu.secretsanta.secretsanta.model.User;
import com.nbu.secretsanta.secretsanta.repository.UserRepository;
import com.nbu.secretsanta.secretsanta.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public void setGifteeToAll() {
        List<User> users = userRepository.findAll();
        List<User> usersGiftees = userRepository.findAll();
        List<Long> userIds = usersGiftees.stream().map(User::getUserId).collect(Collectors.toList());
        int size = users.size();
        for(User u : users){
           User giftee = getGifteeForOne(u, usersGiftees,userIds);
           userIds.remove(giftee.getUserId());
           usersGiftees.remove(giftee);
        }
    }

    private User getGifteeForOne(User user, List<User> users, List<Long> ids) {
        Long randomId = getRandomId(ids);
        User giftee = userRepository.findByUserId(randomId);

        while (giftee == null || !users.contains(giftee) || Objects.equals(user.getUserId(), randomId)){
            randomId = getRandomId(ids);
            giftee = userRepository.findByUserId(randomId);
        }

            user.setGiftee(giftee);
            userRepository.save(user);
        return giftee;
    }

    private Long getRandomId(List<Long> ids) {
        Collections.shuffle(ids);
        return ids.get(0);
    }
}
