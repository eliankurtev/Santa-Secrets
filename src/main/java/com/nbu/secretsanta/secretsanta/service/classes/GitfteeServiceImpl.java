package com.nbu.secretsanta.secretsanta.service.classes;

import com.nbu.secretsanta.secretsanta.DTO.GifteeDto;
import com.nbu.secretsanta.secretsanta.model.User;
import com.nbu.secretsanta.secretsanta.repository.UserRepository;
import com.nbu.secretsanta.secretsanta.service.interfaces.GifteeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GitfteeServiceImpl implements GifteeService {
    @Autowired
    private UserRepository userRepository;

    private final ScheduledExecutorService shufflingScheduler = Executors.newSingleThreadScheduledExecutor();

    private void setGifteeToAll() {
        List<User> users = userRepository.findByIsRegisteredTrue();
        List<User> usersGiftees = userRepository.findByIsRegisteredTrue();
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

        if (!user.getIsRegistered()) {
            return user;
        }

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
    public void scheduleShuffling(String gameDuration) {
        Runnable scheduleShufflingTask = this::setGifteeToAll;
        log.info("Scheduling employee shuffling");
        Duration duration = Duration.between(LocalDateTime.now(), parseDate(gameDuration).plusMinutes(1));
        shufflingScheduler.schedule(scheduleShufflingTask, duration.getSeconds(), TimeUnit.SECONDS);
    }

    @Override
    public GifteeDto getGifteeData(Long user) {
        User user1 = userRepository.findByUserId(user);
        User giftee = user1.getGiftee();
        return GifteeDto.builder()
                .hobbies(giftee.getHobbies())
                .name(giftee.getName())
                .build();
    }

    @Override
    public LocalDateTime parseDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(date, formatter);

    }
}
