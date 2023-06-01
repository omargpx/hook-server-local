package com.araujoprada.hook.service;

import com.araujoprada.hook.entity.Customer;
import com.araujoprada.hook.entity.Route;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAll();
    Customer getById(int id);
    Customer save(Customer customer);

    //region filters
    List<Customer> findByName(String name);
    List<Customer> getAllByStatus(boolean statusSale);
    List<Customer> findCustomersByRoutes(String code,boolean status);
    Customer findByIdentification(String identification);
    //endregion
}
