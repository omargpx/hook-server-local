package com.araujoprada.hook.service.logic;

import com.araujoprada.hook.entity.Location;
import com.araujoprada.hook.errors.GUSException;
import com.araujoprada.hook.model.SERVICES;
import com.araujoprada.hook.repo.LocationDao;
import com.araujoprada.hook.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocationServiceImp implements LocationService {

    @Autowired
    private LocationDao repo;

    @Override
    public List<Location> getAll() {
        List<Location> locations = repo.findAll();
        if(!locations.isEmpty())
            return locations;
        throw new GUSException(SERVICES.LOCATION_SERVICE.name(), null, HttpStatus.NO_CONTENT);
    }

    @Override
    public Location save(Location location) {
        return repo.save(location);
    }

    @Override
    public Location getById(int id) {
        Location location = repo.findById(id).orElse(null);
        if(null!=location)
            return location;
        throw new GUSException(SERVICES.LOCATION_SERVICE.name(), null, HttpStatus.NOT_FOUND);
    }
}
