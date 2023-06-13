package com.araujoprada.hook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "tmv_vehicle_routes")
public class Bundle implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehicle_route")
    private int id;
    @Column(name = "no_vehicle_route")
    private String name;
    @Column(name = "date_init")
    private LocalDateTime init;
    @Column(name = "date_end")
    private LocalDateTime end;
    @Column(name = "date_execution")
    private LocalDate execution;

    @JsonIgnoreProperties({"vbusiness"})
    @ManyToOne
    @JoinColumn(name = "id_vr_vehicle")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "id_vr_route")
    private Route route;

    @JsonIgnoreProperties({"bundle","customer"})
    @OneToMany(mappedBy = "bundle", fetch = FetchType.LAZY)
    private List<Delivery> deliveries;
}
