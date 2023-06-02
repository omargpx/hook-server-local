package com.araujoprada.hook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "TAX_VEHICLES")
public class Vehicle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehicle")
    private int id;
    @Column(name = "co_vehicle")
    private String code;
    @Column(name = "nu_wheels")
    private int wheels;
    @Column(name = "identifier_plate")
    private String plaque;
    @Column(name = "brand")
    private String brand;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_vehicles_business")
    private Business vBusiness;

    @JsonIgnore
    @OneToMany(mappedBy = "vehicle")
    private List<Bundle> bundles;
}
