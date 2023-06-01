package com.araujoprada.hook.service;

import com.araujoprada.hook.entity.People;
import java.util.List;
import java.util.Optional;

public interface PeopleService {
    List<People> getAll();
    People getById(int id);
    People save(People people,int businessId);
    People findPeopleByName(String name);
}