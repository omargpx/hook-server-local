package com.araujoprada.hook.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "TAX_DELIVERY")
public class Delivery implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_delivery")
    private int id;
    @Column(name = "time")
    private String time;
    @Column(name = "nu_difficulty")
    private char difficulty;
    @Column(name = "es_delivery")
    private boolean status;
    private int id_vehicleRoute;//TODO: join whit the trust tables
    private int id_customer;

}
