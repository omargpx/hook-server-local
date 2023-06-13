package com.araujoprada.hook.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Column(name = "ti_pay")
    private char pay;
    @Column(name = "desc_delivery")
    private String description;

    @JsonIgnoreProperties({"vehicle","route","deliveries"})
    @ManyToOne
    @JoinColumn(name = "id_delivery_vehicle_route")
    private Bundle bundle;// vehicle_routes

    @JsonIgnoreProperties({"routeCustomer","trackingSales","cusDistrict","deliveries"})
    @ManyToOne
    @JoinColumn(name = "id_delivery_customer")
    private Customer customer;
}
