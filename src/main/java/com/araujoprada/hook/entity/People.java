package com.araujoprada.hook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "TMA_PEOPLE")
public class People implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_people")
    private int id;
    @Column(name = "co_people")
    private String code;
    @Column(name = "no_people")
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_peo_business")
    private Business pBusiness;
}
