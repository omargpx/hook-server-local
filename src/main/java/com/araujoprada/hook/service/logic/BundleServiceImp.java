package com.araujoprada.hook.service.logic;

import com.araujoprada.hook.entity.Bundle;
import com.araujoprada.hook.errors.GUSException;
import com.araujoprada.hook.model.SERVICES;
import com.araujoprada.hook.repo.BundleDao;
import com.araujoprada.hook.service.BundleService;
import org.ietf.jgss.GSSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BundleServiceImp implements BundleService {

    @Autowired
    private BundleDao repo;

    @Override
    public List<Bundle> getAll() {
        List<Bundle> bundles = repo.findAll();
        if(!bundles.isEmpty())
            return bundles;
        throw new GUSException(SERVICES.BUNDLE_SERVICE.name(),null, HttpStatus.NO_CONTENT);
    }

    @Override
    public Bundle getById(int id) {
        Bundle bundle = repo.findById(id).orElse(null);
        if(null!=bundle)
            return bundle;
        throw new GUSException(SERVICES.BUNDLE_SERVICE.name(),null, HttpStatus.NOT_FOUND);
    }

    @Override
    public Bundle save(Bundle bundle) {
        return repo.save(bundle);
    }
}
