package com.nbu.secretsanta.secretsanta.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "gift")
@NoArgsConstructor
public class Gift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long giftId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private String price;

    @Column(name = "hobby_id")
    private String hobbyId;

    @Override
    public String toString(){
        return "Name of the gift: " + name + ". Price of the gift:" + price;
    }
}
