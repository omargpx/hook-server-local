package com.araujoprada.hook.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "TAX_TRACKING_SALE")
public class TrackingSale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tracking_sale")
    private int id;
    @Column(name = "date_sale")
    private LocalDate date;
    @Column(name = "ti_sale")
    private char type_sale;

    @ManyToOne
    @JoinColumn(name = "id_ts_customer")
    private Customer tsCustomer;
}
