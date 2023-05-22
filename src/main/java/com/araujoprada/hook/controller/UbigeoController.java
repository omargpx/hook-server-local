package com.araujoprada.hook.controller;

import com.araujoprada.hook.entity.Department;
import com.araujoprada.hook.model.infoResponse;
import com.araujoprada.hook.service.GUSServices;
import com.araujoprada.hook.service.UbigeoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ubigeo")
public class UbigeoController {

    @Autowired
    private GUSServices gus;
    @Autowired
    private UbigeoService service;

    @GetMapping("/department")
    public ResponseEntity<?> getDepartments(@RequestParam(name = "id",required = false)Integer id){
        if(null!=id)
            return ResponseEntity.ok(service.getDepartmentById(id));
        return ResponseEntity.ok(service.getDepartments());
    }

    @GetMapping("/province")
    public ResponseEntity<?> getProvinces(@RequestParam(name = "id",required = false)Integer id){
        if(null!=id)
            return ResponseEntity.ok(service.getProvinceById(id));
        return ResponseEntity.ok(service.getProvinces());
    }

    @GetMapping("/district")
    public ResponseEntity<?> getDistricts(@RequestParam(name = "id",required = false)Integer id){
        if (null!=id)
            return ResponseEntity.ok(service.getDistrictById(id));
        return ResponseEntity.ok(service.getDistricts());
    }

    @RequestMapping("/**")
    public ResponseEntity<?> handleInvalidRequest(HttpServletRequest request) {
        infoResponse response = new infoResponse(request.getRequestURL().toString(),"Wrong url. check the path entered",null);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
