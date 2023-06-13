package com.araujoprada.hook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "TAX_DEPARTMENT")
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_department")
    private int id;
    @Column(name = "no_department")
    private String name;

    @JsonIgnoreProperties({"districts","department"})
    @OneToMany(mappedBy = "department")
    private List<Province> provinces;
}
