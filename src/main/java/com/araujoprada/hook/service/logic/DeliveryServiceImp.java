package com.araujoprada.hook.service.logic;

import com.araujoprada.hook.entity.Delivery;
import com.araujoprada.hook.errors.GUSException;
import com.araujoprada.hook.model.SERVICES;
import com.araujoprada.hook.repo.DeliveryDao;
import com.araujoprada.hook.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImp implements DeliveryService {

    @Autowired
    private DeliveryDao repo;

    @Override
    public List<Delivery> getAll() {
        List<Delivery> deliveries = repo.findAll();
        if(!deliveries.isEmpty())
            return deliveries;
        throw new GUSException(SERVICES.DELIVERY_SERVICE.name(), null, HttpStatus.NO_CONTENT);
    }

    @Override
    public Delivery getById(int id) {
        Delivery delivery = repo.findById(id).orElse(null);
        if(null!=delivery)
            return delivery;
        throw new GUSException(SERVICES.DELIVERY_SERVICE.name(), null, HttpStatus.NO_CONTENT);
    }

    @Override
    public Delivery save(Delivery delivery) {
        return repo.save(delivery);
    }

}
