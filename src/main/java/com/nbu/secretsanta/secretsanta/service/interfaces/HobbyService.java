package com.nbu.secretsanta.secretsanta.service.interfaces;

import com.nbu.secretsanta.secretsanta.DTO.HobbyDto;
import com.nbu.secretsanta.secretsanta.model.Hobby;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public interface HobbyService {
    List<Hobby> getAll();
    LinkedList<Hobby> topFive();

    List<HobbyDto> getHobbyDtos();

    Optional<Hobby> getByName(String name);
}
