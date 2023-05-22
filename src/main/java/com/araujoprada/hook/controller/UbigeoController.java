package com.araujoprada.hook.controller;

import com.araujoprada.hook.entity.Department;
import com.araujoprada.hook.service.UbigeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ubigeo")
public class UbigeoController {

    @Autowired
    private UbigeoService service;

    /*
    @GetMapping("/department")
    public ResponseEntity<List<Department>> getDepartments(){
        return ResponseEntity.ok(service.getDepartments());
    }
    @GetMapping("/department/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable int id){
        return ResponseEntity.ok(service.getDepartmentById(id));
    }
    * **/

    @GetMapping("/department/{id}")
    public ResponseEntity<?> getDepartments(@PathVariable( name="id", required = false)Integer id){
        if(null==id)
            return ResponseEntity.ok(service.getDepartments());
        return ResponseEntity.ok(service.getDepartmentById(id));
    }
}
