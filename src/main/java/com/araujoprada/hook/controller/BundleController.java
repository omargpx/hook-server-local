package com.araujoprada.hook.controller;

import com.araujoprada.hook.entity.Bundle;
import com.araujoprada.hook.entity.Route;
import com.araujoprada.hook.entity.Vehicle;
import com.araujoprada.hook.errors.GUSException;
import com.araujoprada.hook.model.SERVICES;
import com.araujoprada.hook.service.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Objects;

@RestController
@RequestMapping("/bundle")
public class BundleController {

    //region ATTRIBUTES
    @Autowired
    private BundleService service;
    @Autowired
    private Environment env;
    private final String serviceName = SERVICES.BUNDLE_SERVICE.name();
    @Autowired
    private GUSServices gus;
    @Autowired
    private RouteService routeService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private CustomerService customerService;
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

    @GetMapping("/current")
    public ResponseEntity<?> findByDateBetween(@RequestParam(name = "token",required = false)String TOKEN,
                                               @RequestParam(name = "init",required = false)LocalDate init,
                                               @RequestParam(name = "end",required = false)LocalDate end,
                                               HttpServletRequest request){
        if(!Objects.equals(TOKEN, env.getProperty("config.hook-access.security-token-permission")))
            throw new GUSException(serviceName,null, HttpStatus.UNAUTHORIZED);
        if(null!=init && null!=end)
            return ResponseEntity.ok(gus.getResponse(request,serviceName,service.getBundlesByDate(init,end),HttpStatus.OK));
        LocalDate today = LocalDate.now();
        return ResponseEntity.ok(gus.getResponse(request,serviceName,service.getBundlesByDate(today.minusDays(1),today.plusDays(1)),HttpStatus.OK));
    }

    @PostMapping("/add")
    public ResponseEntity<?> createBundle(@RequestParam(name = "token",required = false)String TOKEN,
                                          @RequestParam(name = "vehicleId",required = false)Integer vehicleId,
                                          @RequestParam(name = "route",required = false)String code_route,
                                          @RequestBody Bundle bundle, HttpServletRequest request){
        if(!Objects.equals(TOKEN, env.getProperty("config.hook-access.security-token-permission")))
            throw new GUSException(serviceName,null, HttpStatus.UNAUTHORIZED);
        Route route = routeService.findByCode(code_route);
        Vehicle vehicle = vehicleService.getById(vehicleId);
        if(null==route || null==vehicle)
            throw new GUSException(serviceName,bundle,HttpStatus.BAD_REQUEST);
        bundle.setVehicle(vehicle);
        bundle.setRoute(route);
        return ResponseEntity.ok(gus.getResponse(request,serviceName,service.save(bundle),HttpStatus.OK));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateBundle(@RequestParam(name = "token",required = false)String TOKEN,
                                          @RequestParam(name = "id",required = false)Integer id,
                                          @RequestBody Bundle up_bundle, HttpServletRequest request){
        if(!Objects.equals(TOKEN, env.getProperty("config.hook-access.security-token-permission")))
            throw new GUSException(serviceName,null, HttpStatus.UNAUTHORIZED);
        Bundle bundle = service.getById(id);
        // Set de content en caso de que sea null que permanezca igual
        bundle.setRoute(up_bundle.getRoute() !=null ? up_bundle.getRoute() : bundle.getRoute());
        bundle.setInit(up_bundle.getInit() != null ? up_bundle.getInit() : bundle.getInit());
        bundle.setEnd(up_bundle.getEnd() != null ? up_bundle.getEnd() : bundle.getEnd());
        bundle.setExecution(up_bundle.getExecution() != null? up_bundle.getExecution() : bundle.getExecution());
        bundle.setVehicle(up_bundle.getVehicle() != null? up_bundle.getVehicle() : bundle.getVehicle());
        bundle.setName(up_bundle.getName() != null ? up_bundle.getName() : bundle.getName());
        return ResponseEntity.ok(gus.getResponse(request,serviceName,service.save(bundle),HttpStatus.OK));
    }
}
