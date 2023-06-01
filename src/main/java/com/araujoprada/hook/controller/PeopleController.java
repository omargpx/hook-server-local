package com.araujoprada.hook.controller;

import com.araujoprada.hook.entity.People;
import com.araujoprada.hook.errors.GUSException;
import com.araujoprada.hook.model.ErrorResponse;
import com.araujoprada.hook.model.SERVICES;
import com.araujoprada.hook.service.GUSServices;
import com.araujoprada.hook.service.PeopleService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/people")
public class PeopleController {

    //region ATTRIBUTES
    @Autowired
    private Environment env;
    @Autowired
    private PeopleService service;
    @Autowired
    private GUSServices gus;
    private final String serviceName = SERVICES.PEOPLE_SERVICE.name();
    //endregion

    @GetMapping
    public ResponseEntity<?> getAllAndFilters(@RequestParam(name = "id",required = false)Integer id,
                                              @RequestParam(name = "name",required = false)String name,
                                              @RequestParam(name = "token",required = false)String TOKEN,HttpServletRequest request){
        if(!Objects.equals(TOKEN, env.getProperty("config.hook-access.security-token-permission")))
            throw new GUSException(serviceName,null,HttpStatus.UNAUTHORIZED);
        if(null!=id)
            return ResponseEntity.ok(gus.getResponse(request,serviceName,service.getById(id),HttpStatus.OK));
        if(null!=name)
            return ResponseEntity.ok(gus.getResponse(request,serviceName,service.findPeopleByName(name),HttpStatus.OK));
        return ResponseEntity.ok(gus.getResponse(request,serviceName,service.getAll(),HttpStatus.OK));
    }

    @PostMapping("/new")
    public ResponseEntity<?> createPerson(@RequestBody People people,HttpServletRequest request,
                                          @RequestParam(name = "businessId")Integer businessId,
                                          @RequestParam(name = "token",required = false)String TOKEN){
        if(!Objects.equals(TOKEN, env.getProperty("config.hook-access.security-token-permission")))
            throw new GUSException(serviceName,null,HttpStatus.UNAUTHORIZED);
        return ResponseEntity.ok(gus.getResponse(request,serviceName,service.save(people,businessId),HttpStatus.OK));
    }
}
