package com.araujoprada.hook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "TAX_DISTRICT")
public class District implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_district")
    private int id;
    @Column(name = "no_district")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_dis_province")
    private Province province;

    @OneToMany(mappedBy = "bssDistrict")
    @JsonIgnore
    private List<Business> businesses;

    @OneToMany(mappedBy = "cusDistrict")
    @JsonIgnore
    private List<Customer> customers;
}
