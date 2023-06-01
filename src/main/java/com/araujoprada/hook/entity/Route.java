package com.araujoprada.hook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "TAX_ROUTES")
public class Route implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_route")
    private int id;
    @Column(name = "co_route")
    private String code;
    @Column(name = "no_route")
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_rou_business")
    private Business business;

    @JsonIgnore
    @OneToMany(mappedBy = "route")
    private List<Customer> customers;
}
