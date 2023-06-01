package com.araujoprada.hook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "TMA_PEOPLE")
public class People implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_people")
    private int id;
    @Column(name = "co_person")
    private String code;
    @Column(name = "no_person")
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_peo_business")
    private Business pBusiness;


    @ManyToMany
    @JoinTable(name = "tmv_person_role",joinColumns = @JoinColumn(name = "id_person"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    List<Role> roles;
}
