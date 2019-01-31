package com.nbu.secretsanta.secretsanta.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;


@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;

    @Column(name = "name")
    private String name;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "is_admin")
    private Boolean isAdmin;

    @Column(name = "is_registered")
    private Boolean isRegistered;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "password")
    private String password;


    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.ALL,
            })
    @JoinTable(name = "users_hobby",
            joinColumns = {@JoinColumn(name = "users_id")},
            inverseJoinColumns = {@JoinColumn(name = "hobby_id")})
    private Set<Hobby> hobbies = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "giftee")
    private User giftee;

    @Override
    public String toString() {
        return "";
    }

    @Override
    public boolean equals(Object o) {
        return o == this;
    }
}
