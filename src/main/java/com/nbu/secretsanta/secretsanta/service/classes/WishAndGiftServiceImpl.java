package com.nbu.secretsanta.secretsanta.service.classes;

import com.nbu.secretsanta.secretsanta.model.Gift;
import com.nbu.secretsanta.secretsanta.model.Wish;
import com.nbu.secretsanta.secretsanta.repository.GiftRepository;
import com.nbu.secretsanta.secretsanta.repository.WishRepository;
import com.nbu.secretsanta.secretsanta.service.interfaces.WishAndGiftService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class WishAndGiftServiceImpl implements WishAndGiftService {
    private final WishRepository wishRepository;
    private final GiftRepository giftRepository;

    @Autowired
    public WishAndGiftServiceImpl(WishRepository wishRepository, GiftRepository giftRepository){
        this.giftRepository = giftRepository;
        this.wishRepository = wishRepository;
    }

    @Override
    public Gift drowRandGift() {
        List<Long> ids = new LinkedList<>();
        List<Gift> gifts = giftRepository.findAll();
        for (Gift gift: gifts){
            ids.add(gift.getGiftId());
        }
        //Collections.shuffle(ids);
        Random r = new Random();
        //int a = r.nextInt(ids.size());
        return giftRepository.getOne(ids.get(r.nextInt(ids.size())));
    }

    @Override
    public Wish drowRandWish() {

        List<Long> ids = new LinkedList<>();
        List<Wish> wishes = wishRepository.findAll();
        for (Wish wish: wishes){
            ids.add(wish.getWishId());
        }
        Random r = new Random();
        return wishRepository.getOne(ids.get(r.nextInt(ids.size())));
    }
}
