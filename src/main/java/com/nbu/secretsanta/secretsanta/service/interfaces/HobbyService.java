package com.nbu.secretsanta.secretsanta.service.interfaces;

import com.nbu.secretsanta.secretsanta.model.Hobby;

import java.util.LinkedList;
import java.util.List;

public interface HobbyService {
    List<Hobby> getAll();
    LinkedList<Hobby> topFive();
}
