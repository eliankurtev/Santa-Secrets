package com.nbu.secretsanta.secretsanta.service.interfaces;

import com.nbu.secretsanta.secretsanta.model.Gift;
import com.nbu.secretsanta.secretsanta.model.Wish;

public interface WishAndGiftService {
    Gift drowRandGift();
    Wish drowRandWish();
}
