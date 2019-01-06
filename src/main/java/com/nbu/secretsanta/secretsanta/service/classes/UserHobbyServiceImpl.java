package com.nbu.secretsanta.secretsanta.service.classes;

import com.nbu.secretsanta.secretsanta.model.Hobby;
import com.nbu.secretsanta.secretsanta.model.User;
import com.nbu.secretsanta.secretsanta.repository.UserRepository;
import com.nbu.secretsanta.secretsanta.service.interfaces.UserHobbyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class UserHobbyServiceImpl implements UserHobbyService {
    private final UserRepository userRepository;
    @Autowired
    public UserHobbyServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Hobby> top5Hobbies(){
        List<Hobby> topHobbies = new ArrayList<>();
        List<User> users;
        users = userRepository.findAll();
        Map<Hobby, Integer> hobbyMap = new HashMap<>();
        for(User user: users){
            for( Hobby hobby: user.getHobbies()){
                hobbyMap.put(hobby, hobbyMap.get(hobby)+1);
            }
        }
        List<Map.Entry<Hobby, Integer>> list = new LinkedList<>(hobbyMap.entrySet());
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
        for(int i = 0; i < 5; i++){
            topHobbies.add(((LinkedList<Map.Entry<Hobby, Integer>>) list).getLast().getKey());
        }
        return topHobbies;
    }


}
