package com.araujoprada.hook.controller;

import com.araujoprada.hook.entity.People;
import com.araujoprada.hook.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleService service;

    @GetMapping
    public ResponseEntity<?> getAllAndFilters(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/new")
    public ResponseEntity<?> createPerson(@RequestBody People people){
        return ResponseEntity.ok(service.save(people));
    }
}
