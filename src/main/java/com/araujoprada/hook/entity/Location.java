package com.araujoprada.hook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "TAX_LOCATIONS")
public class Location implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_location")
    private int id;
    @Column(name = "co_lat")
    private String latitude;
    @Column(name = "co_log")
    private String longitude;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_loc_customers")
    private Customer locCustomer;
}
