package com.araujoprada.hook.service.logic;

import com.araujoprada.hook.entity.Business;
import com.araujoprada.hook.errors.GUSException;
import com.araujoprada.hook.model.SERVICES;
import com.araujoprada.hook.repo.BusinessDao;
import com.araujoprada.hook.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessServiceImp implements BusinessService {

    @Autowired
    private BusinessDao repo;

    @Override
    public List<Business> getAll() {
        List<Business> business = repo.findAll();
        if (!business.isEmpty())
            return business;
        throw new GUSException(SERVICES.BUSINESS_SERVICE.name(), null, HttpStatus.NO_CONTENT);
    }

    @Override
    public Business getById(int id) {
        Business business = repo.findById(id).orElse(null);
        if(null!=business)
            return business;
        throw new GUSException(SERVICES.BUSINESS_SERVICE.name(), null, HttpStatus.NOT_FOUND);
    }
}
