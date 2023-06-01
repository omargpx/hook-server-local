package com.araujoprada.hook.controller;

import com.araujoprada.hook.errors.GUSException;
import com.araujoprada.hook.model.SERVICES;
import com.araujoprada.hook.service.GUSServices;
import com.araujoprada.hook.service.LocationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService service;
    @Autowired
    private Environment env;
    @Autowired
    private GUSServices gus;
    private final String serviceName = SERVICES.LOCATION_SERVICE.name();

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(name = "token",required = false)String TOKEN,
                                    @RequestParam(name = "id",required = false)Integer id,
                                    HttpServletRequest request){
        if(!Objects.equals(TOKEN, env.getProperty("config.hook-access.security-token-permission")))
            throw new GUSException(serviceName,null, HttpStatus.UNAUTHORIZED);
        if(null!=id)
            return ResponseEntity.ok(gus.getResponse(request,serviceName,service.getById(id),HttpStatus.OK));
        return ResponseEntity.ok(gus.getResponse(request,serviceName,service.getAll(),HttpStatus.OK));
    }
}
