package com.nbu.secretsanta.secretsanta.model;

import lombok.Builder;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;

    @Column(name = "name")
    private String name;

    @Email
    @Column(name = "e-mail")
    private String email;

    @Column(name = "is_admin")
    private Boolean isAdmin;

    @Column(name = "is_registered")
    private Boolean isRegistered;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "password")
    private Integer password;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "user_hobby",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "hobby_id") })
    private Set<Hobby> hobbies = new HashSet<>();


}
