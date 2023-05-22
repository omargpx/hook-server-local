package com.araujoprada.hook.controller;

import com.araujoprada.hook.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleService service;

    @GetMapping
    public ResponseEntity<?> getAllAndFilters(){
        return ResponseEntity.ok(service.getAll());
    }
}
