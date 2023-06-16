package com.araujoprada.hook.controller;

import com.araujoprada.hook.entity.Business;
import com.araujoprada.hook.entity.Customer;
import com.araujoprada.hook.entity.Location;
import com.araujoprada.hook.entity.Route;
import com.araujoprada.hook.errors.GUSException;
import com.araujoprada.hook.model.SERVICES;
import com.araujoprada.hook.service.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    //region ATTRIBUTES
    @Autowired
    private CustomerService service;
    @Autowired
    private Environment env;
    @Autowired
    private GUSServices gus;
    private final String serviceName = SERVICES.CUSTOMER_SERVICE.name();
    @Autowired
    private RouteService routeService;
    @Autowired
    private BusinessService businessService;
    @Autowired
    private LocationService locationService;
    //endregion


    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(name = "token",required = false)String TOKEN,
                                    @RequestParam(name = "id",required = false)Integer id,
                                    @RequestParam(name = "name",required = false)String name,
                                    @RequestParam(name = "identification",required = false)String identify,
                                    HttpServletRequest request){
        if(!Objects.equals(TOKEN, env.getProperty("config.hook-access.security-token-permission")))
            throw new GUSException(serviceName,null, HttpStatus.UNAUTHORIZED);
        if(null!=id)
            return ResponseEntity.ok(gus.getResponse(request,serviceName,service.getById(id),HttpStatus.OK));
        if(null!=name)
            return ResponseEntity.ok(gus.getResponse(request,serviceName,service.findByName(name),HttpStatus.OK));
        if(null!=identify)
            return ResponseEntity.ok(gus.getResponse(request,serviceName,service.findByIdentification(identify),HttpStatus.OK));
        return ResponseEntity.ok(gus.getResponse(request,serviceName,service.getAll(),HttpStatus.OK));
    }

    @PutMapping("/prepare")
    public ResponseEntity<?> prepareCustomer(@RequestParam(name = "token",required = false)String TOKEN,
                                             @RequestParam(name = "customerId",required = false)Integer customer_id,
                                             @RequestParam(name = "status",required = false)Boolean status,
                                             HttpServletRequest request){
        if(!Objects.equals(TOKEN, env.getProperty("config.hook-access.security-token-permission")))
            throw new GUSException(serviceName,null, HttpStatus.UNAUTHORIZED);
        Customer customer = service.getById(customer_id);
        customer.setStatusSale(Objects.requireNonNullElse(status,false));
        return ResponseEntity.ok(gus.getResponse(request,serviceName,service.save(customer),HttpStatus.OK));
    }

    @GetMapping("/filter")
    public ResponseEntity<?> getCustomersByRoutes(@RequestParam(name = "token",required = false)String TOKEN,
                                                  @RequestParam(name = "route",required = false)String code,
                                                  @RequestParam(name = "status",required = false)Boolean status,
                                                  HttpServletRequest request){
        if(!Objects.equals(TOKEN, env.getProperty("config.hook-access.security-token-permission")))
            throw new GUSException(serviceName,null, HttpStatus.UNAUTHORIZED);
        if(null!=code && null!=status)
            return ResponseEntity.ok(gus.getResponse(request,serviceName,service.filterCustomerByRouteAndStatus(code, status),HttpStatus.OK));
        return ResponseEntity.ok(gus.getResponse(request,serviceName,service.filterCustomersByRoute(code),HttpStatus.OK));
    }

    @PostMapping("/new")
    public ResponseEntity<?> createCustomer(@RequestParam(name = "token",required = false)String TOKEN,
                                            @RequestBody Customer customer, HttpServletRequest request,
                                            @RequestParam(name = "route",required = false)String code_route,
                                            @RequestParam(name = "businessId",required = false)Integer businessId){
        if(!Objects.equals(TOKEN, env.getProperty("config.hook-access.security-token-permission")))
            throw new GUSException(serviceName,null, HttpStatus.UNAUTHORIZED);
        Route route = routeService.findByCode(code_route);
        Business business = businessService.getById(businessId);
        if(null==route || null==business)
            throw new GUSException(serviceName,null,HttpStatus.BAD_REQUEST);
        customer.setRouteCustomer(route);
        customer.setCBusiness(business);
        return ResponseEntity.ok(gus.getResponse(request,serviceName,service.save(customer),HttpStatus.OK));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCustomer(@RequestParam(name = "token",required = false)String TOKEN,
                                            @RequestParam(name = "id",required = false)Integer id,
                                            @RequestBody Customer c, HttpServletRequest request){
        if(!Objects.equals(TOKEN, env.getProperty("config.hook-access.security-token-permission")))
            throw new GUSException(serviceName,null, HttpStatus.UNAUTHORIZED);
        Customer customer = service.getById(id);
        customer.setIdentification(c.getIdentification() != null? c.getIdentification() : customer.getIdentification());
        customer.setPhone(c.getPhone() != null ? c.getPhone() : customer.getPhone());
        customer.setName(c.getName() != null ? c.getName() : customer.getName());
        customer.setRouteCustomer(c.getRouteCustomer() != null ? c.getRouteCustomer() : customer.getRouteCustomer());
        customer.setDirection(c.getDirection() != null ? c.getDirection() : customer.getDirection());
        customer.setReference(c.getReference() != null ? c.getReference() : customer.getReference());
        customer.setCusDistrict(c.getCusDistrict() != null ? c.getCusDistrict() : customer.getCusDistrict());
        customer.setCBusiness(c.getCBusiness() != null ? c.getCBusiness() : customer.getCBusiness());
        customer.setLocation(c.getLocation() != null ? c.getLocation() : customer.getLocation());
        return ResponseEntity.ok(gus.getResponse(request,serviceName,service.save(customer),HttpStatus.OK));
    }

    @PutMapping("/setLocation")
    public ResponseEntity<?> setLocation(@RequestParam(name = "token")String TOKEN,
                                         @RequestParam(name = "id")Integer id,
                                         @RequestBody Location location, HttpServletRequest r){
        if(!Objects.equals(TOKEN, env.getProperty("config.hook-access.security-token-permission")))
            throw new GUSException(serviceName,null, HttpStatus.UNAUTHORIZED);
        Customer customer = service.getById(id);
        if(null==customer)
            throw new GUSException(serviceName,null,HttpStatus.NOT_FOUND);
        customer.setLocation(locationService.save(location));
        return ResponseEntity.ok(gus.getResponse(r,serviceName,service.save(customer),HttpStatus.OK));
    }


}
