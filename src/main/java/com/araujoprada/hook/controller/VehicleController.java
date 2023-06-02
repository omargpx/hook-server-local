package com.araujoprada.hook.controller;

import com.araujoprada.hook.errors.GUSException;
import com.araujoprada.hook.model.SERVICES;
import com.araujoprada.hook.service.GUSServices;
import com.araujoprada.hook.service.VehicleService;
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
@RequestMapping("/vehicle")
public class VehicleController {

    //region attributes
    @Autowired
    private VehicleService service;
    @Autowired
    private Environment env;
    private final String serviceName = SERVICES.VEHICLE_SERVICE.name();

    @Autowired
    private GUSServices gus;
    //endregion

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(name = "token",required = false)String TOKEN,
                                    @RequestParam(name = "id",required = false)Integer id,
                                    @RequestParam(name = "code",required = false)String code,
                                    @RequestParam(name = "plaque",required = false)String plaque,
                                    @RequestParam(name = "brand",required = false)String brand,
                                    HttpServletRequest request){
        if(!Objects.equals(TOKEN, env.getProperty("config.hook-access.security-token-permission")))
            throw new GUSException(serviceName,null, HttpStatus.UNAUTHORIZED);
        if(null!=id)
            return ResponseEntity.ok(gus.getResponse(request,serviceName,service.getById(id),HttpStatus.OK));
        if (null!=code)
            return ResponseEntity.ok(gus.getResponse(request,serviceName,service.findByCode(code),HttpStatus.OK));
        if(null!=plaque)
            return ResponseEntity.ok(gus.getResponse(request,serviceName,service.findByPlaque(plaque),HttpStatus.OK));
        if(null!=brand)
            return ResponseEntity.ok(gus.getResponse(request,serviceName,service.findByBrand(brand),HttpStatus.OK));
        return ResponseEntity.ok(gus.getResponse(request,serviceName,service.getAll(),HttpStatus.OK));
    }
}
