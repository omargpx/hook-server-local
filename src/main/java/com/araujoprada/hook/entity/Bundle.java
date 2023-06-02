package com.araujoprada.hook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tmv_vehicle_routes")
public class Bundle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehicle_route")
    private int id;
    @Column(name = "date_init")
    private LocalDateTime init;
    @Column(name = "date_end")
    private LocalDateTime end;
    @Column(name = "date_execution")
    private LocalDate execution;

    @ManyToOne
    @JoinColumn(name = "id_vr_vehicle")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "id_vr_route")
    private Route route;
}
