package com.araujoprada.hook.service.logic;

import com.araujoprada.hook.entity.People;
import com.araujoprada.hook.repo.PeopleDao;
import com.araujoprada.hook.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleServiceImp implements PeopleService {

    @Autowired
    private PeopleDao repo;

    @Override
    public List<People> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<People> getById(int id) {
        return repo.findById(id);
    }
}
