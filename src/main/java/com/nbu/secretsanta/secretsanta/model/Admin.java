package com.nbu.secretsanta.secretsanta.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long adminId;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'")
    @JsonSerialize(using = DateSerializer.class)
    @Column(name = "registration_end_date")
    private Date registrationEndDate;

    @Column(name = "gifts_date")
    private Date giftsDate;

    @Column(name = "price")
    private String adminPrice;
}
