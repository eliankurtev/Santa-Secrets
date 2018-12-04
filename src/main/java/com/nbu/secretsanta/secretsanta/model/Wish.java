package com.nbu.secretsanta.secretsanta.model;

import lombok.Builder;
import lombok.Data;
import javax.persistence.*;

    @Data
    @Builder
    @Entity
    @Table(name = "wish")
    public class Wish {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long wishId;

        @Column(name = "message")
        private String message;
    }
