package com.nbu.secretsanta.secretsanta.service.classes;

import com.nbu.secretsanta.secretsanta.model.Hobby;
import com.nbu.secretsanta.secretsanta.repository.HobbyRepository;
import com.nbu.secretsanta.secretsanta.service.interfaces.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HobbyServiceImpl implements HobbyService {
    private final HobbyRepository hobbyRepository;
    @Autowired
    public HobbyServiceImpl(HobbyRepository hobbyRepository){
        this.hobbyRepository = hobbyRepository;
    }
    @Override
    public List<Hobby> getAll() {
        List<Hobby> hobbies = hobbyRepository.findAll();
        return hobbies;
    }

    @Override
    public LinkedList<Hobby> topFive() {
        LinkedList<Hobby> topFive = new LinkedList<>();
        List<Hobby> hobbies = getAll();
        Map<Hobby, Integer> hobbyMap = new HashMap<>();
        for(Hobby hobby: hobbies){
            hobbyMap.put(hobby,hobby.getEmployees().size());
        }
        for(int i = 0; i <5; i++) {
            Map.Entry<Hobby, Integer> maxEntry = null;

            for (Map.Entry<Hobby, Integer> entry : hobbyMap.entrySet()) {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                    maxEntry = entry;
                }
            }
            topFive.add(maxEntry.getKey());
            hobbies.remove(maxEntry.getKey());
        }
        return topFive;
    }
}
