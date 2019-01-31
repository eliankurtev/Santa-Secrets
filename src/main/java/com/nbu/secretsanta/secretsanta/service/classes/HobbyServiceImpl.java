package com.nbu.secretsanta.secretsanta.service.classes;

import com.nbu.secretsanta.secretsanta.DTO.HobbyDto;
import com.nbu.secretsanta.secretsanta.model.Hobby;
import com.nbu.secretsanta.secretsanta.repository.HobbyRepository;
import com.nbu.secretsanta.secretsanta.service.interfaces.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
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
        for(int i = 0; i <6; i++) {
            Map.Entry<Hobby, Integer> maxEntry = null;

            for (Map.Entry<Hobby, Integer> entry : hobbyMap.entrySet()) {
                if (maxEntry == null || (entry.getValue().compareTo(maxEntry.getValue())) > 0) {
                    maxEntry = entry;
                }
            }
            topFive.add(maxEntry.getKey());
           hobbyMap.remove(maxEntry.getKey());
        }
        return topFive;
    }

    @Override
    public List<HobbyDto> getHobbyDtos() {
        List<HobbyDto> hobbyDtos = new ArrayList<>();
        List<Hobby> allHobbies = new ArrayList<>(getAll());
        for (Hobby allHobby : allHobbies) {
            HobbyDto hobbyDto = new HobbyDto();
            hobbyDto.setName(allHobby.getName());
            hobbyDtos.add(hobbyDto);
        }
        return hobbyDtos;
    }

    @Override
    public Optional<Hobby> getByName(String name){
         return hobbyRepository.findByName(name);
    }
}
