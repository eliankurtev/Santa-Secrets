package com.nbu.secretsanta.secretsanta.model;

import lombok.Builder;
import lombok.Data;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "hobby")
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long hobbyId;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "user")
    private List<User> employees = new LinkedList<>();

}
