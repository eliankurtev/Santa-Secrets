package com.nbu.secretsanta.secretsanta.DTO;

import com.nbu.secretsanta.secretsanta.model.Hobby;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class GifteeDto {
    private String name;
    private Set<Hobby> hobbies;
}
