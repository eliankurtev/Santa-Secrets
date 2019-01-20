package com.nbu.secretsanta.secretsanta.service.classes;

import com.nbu.secretsanta.secretsanta.DTO.GifteeDto;
import com.nbu.secretsanta.secretsanta.model.Admin;
import com.nbu.secretsanta.secretsanta.model.User;
import com.nbu.secretsanta.secretsanta.repository.UserRepository;
import com.nbu.secretsanta.secretsanta.service.interfaces.AdminService;
import com.nbu.secretsanta.secretsanta.service.interfaces.GifteeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GitfteeServiceImpl implements GifteeService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminService adminService;

    private void setGifteeToAll() {
        List<User> users = userRepository.findAll();
        List<User> usersGiftees = userRepository.findAll();
        List<Long> userIds = usersGiftees.stream().map(User::getUserId).collect(Collectors.toList());
        log.info(users.toString());
            for (User u : users) {
                User giftee = getGifteeForOne(u, usersGiftees, userIds);
                userIds.remove(giftee.getUserId());
                usersGiftees.remove(giftee);
            }
    }

    private User getGifteeForOne(User user, List<User> users, List<Long> ids) {
        Long randomId = getRandomId(ids);
        User giftee = userRepository.findByUserId(randomId);

        while (giftee == null || users.contains(giftee) || Objects.equals(user.getUserId(), randomId)) {
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

    @Override
    public void scheduleShuffling() {
        Admin admin = adminService.getAdmin();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                setGifteeToAll();
            }
        }, admin.getRegistrationEndDate());

    }

    @Override
    public GifteeDto getGifteeData(Long user){
        User user1 = userRepository.findByUserId(user);
        User giftee = user1.getGiftee();
        return GifteeDto.builder()
                .hobbies(giftee.getHobbies())
                .name(giftee.getName())
                .build();
    }
}
