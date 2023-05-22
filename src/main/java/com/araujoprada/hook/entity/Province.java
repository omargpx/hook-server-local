package com.araujoprada.hook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "TAX_PROVINCE")
public class Province implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_province")
    private int id;
    @Column(name = "no_province")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_pro_department")
    private Department department;

    @OneToMany(mappedBy = "province")
    @JsonIgnore
    private List<District> districts;
}
