package com.araujoprada.hook.service.logic;

import com.araujoprada.hook.entity.Customer;
import com.araujoprada.hook.errors.GUSException;
import com.araujoprada.hook.model.CustomerDTO;
import com.araujoprada.hook.model.SERVICES;
import com.araujoprada.hook.repo.CustomerDao;
import com.araujoprada.hook.service.CustomerService;
import com.araujoprada.hook.service.GUSServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerDao repo;
    @Autowired
    private GUSServices gus;

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = repo.findAll();
        if (!customers.isEmpty())
            return customers;
        throw new GUSException(SERVICES.CUSTOMER_SERVICE.name(), null,HttpStatus.NO_CONTENT);
    }

    @Override
    public Customer getById(int id) {
        Customer customer = repo.findById(id).orElse(null);
        if (null!=customer)
            return customer;
        throw new GUSException(SERVICES.CUSTOMER_SERVICE.name(), null, HttpStatus.NOT_FOUND);
    }

    @Override
    public Customer save(Customer customer) {
        if(null==customer.getIdentification())
            customer.setIdentification(gus.genIdentificationCode("AP"));
        return repo.save(customer);
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customers = repo.findTop5ByNameContains(name);
        if (!customers.isEmpty())
            return customers;
        throw new GUSException(SERVICES.CUSTOMER_SERVICE.name(), null,HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Customer> getAllByStatus(boolean statusSale) {
        List<Customer> customers = repo.findByStatusSale(statusSale);
        if(!customers.isEmpty())
            return customers;
        throw new GUSException(SERVICES.CUSTOMER_SERVICE.name(), null,HttpStatus.NOT_FOUND);
    }

    @Override
    public List<CustomerDTO> filterCustomerByRouteAndStatus(String code, boolean status) {
        List<CustomerDTO> customersDto = gus.convertCustomersToDtoList(repo.filterCustomerByRouteAndStatus(code,status));
        if(!customersDto.isEmpty())
            return customersDto;
        throw new GUSException(SERVICES.CUSTOMER_SERVICE.name(), null,HttpStatus.NOT_FOUND);
    }

    @Override
    public Customer findByIdentification(String identification) {
        Customer customer = repo.findByIdentification(identification);
        if(null!=customer)
            return customer;
        throw new GUSException(SERVICES.CUSTOMER_SERVICE.name(), null,HttpStatus.NOT_FOUND);
    }

    @Override
    public List<CustomerDTO> filterCustomersByRoute(String code) {
        List<CustomerDTO> customersDto = gus.convertCustomersToDtoList(repo.filterCustomerByRoute(code));
        if(!customersDto.isEmpty())
            return customersDto;
        throw new GUSException(SERVICES.CUSTOMER_SERVICE.name(), null,HttpStatus.NOT_FOUND);
    }
}
