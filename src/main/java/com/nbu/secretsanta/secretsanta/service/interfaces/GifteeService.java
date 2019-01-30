package com.nbu.secretsanta.secretsanta.service.interfaces;

import com.nbu.secretsanta.secretsanta.DTO.GifteeDto;

import java.time.LocalDateTime;

public interface GifteeService {
    void scheduleShuffling(String gameDuration);

    GifteeDto getGifteeData(Long user);

    LocalDateTime parseDate(String date);
}
