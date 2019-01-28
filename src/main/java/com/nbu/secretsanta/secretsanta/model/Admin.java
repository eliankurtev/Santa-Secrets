package com.nbu.secretsanta.secretsanta.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long adminId;

    @Column(name = "registration_end_date")
    private Date registrationEndDate;

    @Column(name = "gifts_date")
    private Date giftsDate;

    @Column(name = "price")
    private String adminPrice;


}
