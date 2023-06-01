package com.araujoprada.hook.controller;

import com.araujoprada.hook.model.InfoResponse;
import com.araujoprada.hook.model.SERVICES;
import com.araujoprada.hook.service.GUSServices;
import com.araujoprada.hook.service.UbigeoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ubigeo")
public class UbigeoController {

    //region ATTRIBUTES
    @Autowired
    private GUSServices gus;
    @Autowired
    private UbigeoService service;
    private final String className = SERVICES.UBIGEO_SERVICE.name();
    //endregion

    @GetMapping("/department")
    public ResponseEntity<?> getDepartments(@RequestParam(name = "id",required = false)Integer id,
                                            @RequestParam(name = "name",required = false)String name,
                                            HttpServletRequest request){
        if(null!=id)
            return ResponseEntity.ok(gus.getResponse(request,className,service.getDepartmentById(id),HttpStatus.OK));
        if(null!=name)
            return ResponseEntity.ok(gus.getResponse(request,className,service.findDepartmentByName(name),HttpStatus.OK));
        return ResponseEntity.ok(gus.getResponse(request,className,service.getDepartments(),HttpStatus.OK));
    }

    @GetMapping("/province")
    public ResponseEntity<?> getProvinces(@RequestParam(name = "id",required = false)Integer id,
                                          @RequestParam(name = "name",required = false)String name,
                                          HttpServletRequest request){
        if(null!=id)
            return ResponseEntity.ok(gus.getResponse(request,className,service.getProvinceById(id),HttpStatus.OK));
        if(null!=name)
            return ResponseEntity.ok(gus.getResponse(request,className,service.findProvinceByName(name),HttpStatus.OK));
        return ResponseEntity.ok(gus.getResponse(request,className,service.getProvinces(),HttpStatus.OK));
    }

    @GetMapping("/district")
    public ResponseEntity<?> getDistricts(@RequestParam(name = "id",required = false)Integer id,
                                          @RequestParam(name = "name",required = false)String name,
                                          HttpServletRequest request){
        if (null!=id)
            return ResponseEntity.ok(gus.getResponse(request,className,service.getDistrictById(id),HttpStatus.OK));
        if(null!=name)
            return ResponseEntity.ok(gus.getResponse(request,className,service.findDistrictByName(name),HttpStatus.OK));
        return ResponseEntity.ok(gus.getResponse(request,className,service.getDistricts(),HttpStatus.OK));
    }

    @RequestMapping("/**")
    public ResponseEntity<?> handleInvalidRequest(HttpServletRequest request) {
        InfoResponse response = new InfoResponse(request.getRequestURL().toString(),"Non-existent URL for Ubigeo API. check the path entered",null);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
