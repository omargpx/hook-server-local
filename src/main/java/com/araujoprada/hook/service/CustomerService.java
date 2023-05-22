package com.araujoprada.hook.service;

import com.araujoprada.hook.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAll();
    Optional<Customer> getCustomer();
}
