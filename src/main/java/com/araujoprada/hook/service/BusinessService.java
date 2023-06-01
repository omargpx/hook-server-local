package com.araujoprada.hook.service;

import com.araujoprada.hook.entity.Business;

import java.util.List;
import java.util.Optional;

public interface BusinessService {
    List<Business> getAll();
    Business getById(int id);
}
