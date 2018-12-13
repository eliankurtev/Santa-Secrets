package com.nbu.secretsanta.secretsanta.model;

import lombok.Builder;
import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "hobbies")
    private Set<User> employees = new HashSet<>();


}
