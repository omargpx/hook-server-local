package com.araujoprada.hook.service;

import com.araujoprada.hook.entity.Delivery;

import java.util.List;

public interface DeliveryService {
    List<Delivery> getAll();
    Delivery getById(int id);
    Delivery save(Delivery delivery);

}
