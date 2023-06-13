package com.araujoprada.hook.model;

import com.araujoprada.hook.entity.*;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CustomerDTO{
    private int id;
    private String name;
    private String identification;
    private String reference;
    private String direction;
    private boolean statusSale;
    private Route ruta;
}
