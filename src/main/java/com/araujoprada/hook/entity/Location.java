package com.araujoprada.hook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

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

    @JsonIgnoreProperties({"location"})
    @OneToOne(mappedBy = "location", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Customer customers;
}
