package com.araujoprada.hook.controller;

import com.araujoprada.hook.entity.Delivery;
import com.araujoprada.hook.errors.GUSException;
import com.araujoprada.hook.model.SERVICES;
import com.araujoprada.hook.service.DeliveryService;
import com.araujoprada.hook.service.GUSServices;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    //region ATTRIBUTES
    @Autowired
    private DeliveryService service;
    @Autowired
    private Environment env;
    @Autowired
    private GUSServices gus;
    private final String serviceName = SERVICES.DELIVERY_SERVICE.name();
    //endregion
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

    @PostMapping("/keep")
    public ResponseEntity<?> saveDelivery(@RequestParam(name = "token",required = false)String TOKEN,
                                                     @RequestBody Delivery delivery, HttpServletRequest request){
        if(!Objects.equals(TOKEN, env.getProperty("config.hook-access.security-token-permission")))
            throw new GUSException(serviceName,null, HttpStatus.UNAUTHORIZED);
        return ResponseEntity.ok(gus.getResponse(request,serviceName,service.save(delivery),HttpStatus.OK));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestParam(name = "token",required = false)String TOKEN,
                                    @RequestBody Delivery delivery, HttpServletRequest request,
                                    @RequestParam(name = "id",required = false)Integer id){
        if(!Objects.equals(TOKEN, env.getProperty("config.hook-access.security-token-permission")))
            throw new GUSException(serviceName,null, HttpStatus.UNAUTHORIZED);
        if(null==id) throw new GUSException(serviceName,null, HttpStatus.BAD_REQUEST);
        Delivery d = service.getById(id);
        d.setTime(delivery.getTime());
        d.setPay(delivery.getPay());
        d.setDifficulty(delivery.getDifficulty());
        d.setDescription(d.getDescription());
        return ResponseEntity.ok(gus.getResponse(request,serviceName,service.save(d),HttpStatus.OK));
    }
}
