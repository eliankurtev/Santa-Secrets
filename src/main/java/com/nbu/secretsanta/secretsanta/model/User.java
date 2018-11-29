package com.nbu.secretsanta.secretsanta.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long userId;
    @Column(name = "username")
    String userName;
    @Column(name = "password")
    String password;
    @Column(name = "is_admin")
    Boolean isAdmin;

}
