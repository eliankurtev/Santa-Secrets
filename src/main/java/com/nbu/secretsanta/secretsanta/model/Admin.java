package com.nbu.secretsanta.secretsanta.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "admin")
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long adminId;

    @Column(name = "registration_end_date")
    private LocalDateTime registrationEndDate;

    @Column(name = "gifts_date")
    private LocalDateTime giftsDate;

    @Column(name = "price")
    private String adminPrice;
}
