package com.nbu.secretsanta.secretsanta.model;

import lombok.Builder;
import lombok.Data;
import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long adminId;

    @Column(name = "registration_end_date")
    private String registrationEndDate;

    @Column(name = "gifts_date")
    private String giftsDate;

    @Column(name = "price")
    private String adminPrice;
}
