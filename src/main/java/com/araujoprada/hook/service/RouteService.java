package com.araujoprada.hook.service;

import com.araujoprada.hook.entity.Route;

import java.util.List;

public interface RouteService {
    List<Route> getAll();
    Route findByCode(String code);
}
