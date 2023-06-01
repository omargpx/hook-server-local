package com.araujoprada.hook.controller;

import com.araujoprada.hook.errors.GUSException;
import com.araujoprada.hook.model.SERVICES;
import com.araujoprada.hook.service.BusinessService;
import com.araujoprada.hook.service.GUSServices;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService service;
    @Autowired
    private Environment env;
    @Autowired
    private GUSServices gus;
    private final String serviceName = SERVICES.BUSINESS_SERVICE.name();

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(name = "id",required = false)Integer id,
                                    @RequestParam(name = "token",required = false)String TOKEN,
                                    HttpServletRequest request){
        if(!Objects.equals(TOKEN, env.getProperty("config.hook-access.security-token-permission")))
            throw new GUSException(serviceName,null, HttpStatus.UNAUTHORIZED);
        if(null!=id)
            return ResponseEntity.ok(gus.getResponse(request,serviceName,service.getById(id),HttpStatus.OK));
        return ResponseEntity.ok(gus.getResponse(request,serviceName,service.getAll(),HttpStatus.OK));
    }

}
