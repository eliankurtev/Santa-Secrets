package com.nbu.secretsanta.secretsanta.service.interfaces;

import com.nbu.secretsanta.secretsanta.DTO.GifteeDto;

public interface GifteeService {
    void scheduleShuffling();

    GifteeDto getGifteeData(Long user);
}
