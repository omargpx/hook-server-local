package com.araujoprada.hook.service.logic;

import com.araujoprada.hook.entity.Business;
import com.araujoprada.hook.entity.People;
import com.araujoprada.hook.errors.GUSException;
import com.araujoprada.hook.model.ErrorResponse;
import com.araujoprada.hook.model.SERVICES;
import com.araujoprada.hook.repo.BusinessDao;
import com.araujoprada.hook.repo.PeopleDao;
import com.araujoprada.hook.service.GUSServices;
import com.araujoprada.hook.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleServiceImp implements PeopleService {

    //region CONNECTIONS
    @Autowired
    private PeopleDao repo;
    @Autowired
    private BusinessDao businessDao;
    @Autowired
    private GUSServices gus;
    //endregion

    @Override
    public List<People> getAll() {
        List<People> people = repo.findAll();
        if (!people.isEmpty())
            return people;
        throw new GUSException(SERVICES.PEOPLE_SERVICE.name(),null, HttpStatus.NO_CONTENT);
    }

    @Override
    public People getById(int id) {
        People people = repo.findById(id).orElse(null);
        if (null!=people)
            return people;
        throw new GUSException(SERVICES.PEOPLE_SERVICE.name(),null, HttpStatus.NOT_FOUND);
    }

    @Override
    public People save(People people, int businessId) {
        Business business = businessDao.findById(businessId).orElse(null);
        people.setPBusiness(business);
        people.setCode(gus.genSecureCode("AP"));
        return repo.save(people);
    }

    @Override
    public People findPeopleByName(String name) {
        People people = repo.findFirstByNameContains(name);
        if (null!=people)
            return people;
        throw new GUSException(SERVICES.PEOPLE_SERVICE.name(),null, HttpStatus.NOT_FOUND);
    }
}
