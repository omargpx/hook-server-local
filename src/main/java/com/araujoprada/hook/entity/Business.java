package com.araujoprada.hook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "TMA_BUSINESS")
public class Business implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_business")
    private int id;
    @Column(name = "no_business")
    private String name;
    @Column(name = "nu_ruc")
    private String RUC;
    @Column(name = "no_zone")
    private String zone;
    @Column(name = "di_business")
    private String direction;

    @JsonIgnoreProperties({"pbusiness","roles"})
    @OneToMany(mappedBy = "pBusiness",fetch = FetchType.EAGER)
    private List<People> people;

    @JsonIgnoreProperties({"deliveries","trackingSales","cbusiness"})
    @OneToMany(mappedBy = "cBusiness",fetch = FetchType.LAZY)
    private List<Customer> customers;

    @JsonIgnoreProperties({"cbusiness"})
    @OneToMany(mappedBy = "vBusiness",fetch = FetchType.EAGER)
    private List<Vehicle> vehicles;

    @ManyToOne
    @JoinColumn(name = "id_bss_district")
    private District bssDistrict;
}
