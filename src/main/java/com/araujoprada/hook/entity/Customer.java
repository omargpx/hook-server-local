package com.araujoprada.hook.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "TMA_CUSTOMERS")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private int id;
    @Column(name = "no_customer")
    private String name;
    @Column(name = "nu_identification")
    private String identification;
    @Column(name = "di_customer")
    private String direction;
    @Column(name = "de_reference")
    private String reference;
    @Column(name = "es_sale")
    private boolean statusSale;

    @JsonIgnoreProperties({"people","customers","vehicles","bssDistrict"})
    @ManyToOne
    @JoinColumn(name = "id_cus_business")
    private Business cBusiness;

    @ManyToOne
    @JoinColumn(name = "id_cus_routes")
    private Route routeCustomer;

    @OneToMany(mappedBy = "tsCustomer",fetch = FetchType.LAZY)
    private List<TrackingSale> trackingSales;

    @JsonIgnoreProperties({"province"})
    @ManyToOne
    @JoinColumn(name = "id_cus_district")
    private District cusDistrict;

    @JsonIgnoreProperties({"customers"})
    @OneToOne
    @JoinColumn(name = "id_cus_location") //insertable = true ; updatable = true
    private Location location;

    @JsonIgnoreProperties({"bundle","customer"})
    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private List<Delivery> deliveries;
}
