package com.araujoprada.hook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "TAX_ROL")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private int id;
    @Column(name = "no_role")
    private String name;
    @Column
    private String description;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    List<People> people;
}
