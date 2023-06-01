package com.araujoprada.hook.service.logic;

import com.araujoprada.hook.entity.Route;
import com.araujoprada.hook.errors.GUSException;
import com.araujoprada.hook.model.SERVICES;
import com.araujoprada.hook.repo.RouteDao;
import com.araujoprada.hook.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImp implements RouteService {

    @Autowired
    private RouteDao repo;

    @Override
    public List<Route> getAll() {
        List<Route> routes = repo.findAll();
        if(!routes.isEmpty())
            return routes;
        throw new GUSException(SERVICES.ROUTE_SERVICE.name(),null, HttpStatus.NO_CONTENT);
    }

    @Override
    public Route findByCode(String code) {
        Route route = repo.findFirstByCodeContains(code);
        if(null!=route)
            return route;
        throw new GUSException(SERVICES.ROUTE_SERVICE.name(), null, HttpStatus.NOT_FOUND);
    }
}
