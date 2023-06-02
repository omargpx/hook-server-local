package com.araujoprada.hook.service.logic;

import com.araujoprada.hook.entity.Vehicle;
import com.araujoprada.hook.errors.GUSException;
import com.araujoprada.hook.model.SERVICES;
import com.araujoprada.hook.repo.VehicleDao;
import com.araujoprada.hook.service.GUSServices;
import com.araujoprada.hook.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleServiceImp implements VehicleService {

    @Autowired
    private VehicleDao repo;
    @Autowired
    private GUSServices gus;

    @Override
    public List<Vehicle> getAll() {
        List<Vehicle> vehicles = repo.findAll();
        if(!vehicles.isEmpty())
            return vehicles;
        throw new GUSException(SERVICES.VEHICLE_SERVICE.name(), null, HttpStatus.NO_CONTENT);
    }

    @Override
    public Vehicle getById(int id) {
        Vehicle vehicle = repo.findById(id).orElse(null);
        if(null!=vehicle)
            return vehicle;
        throw new GUSException(SERVICES.VEHICLE_SERVICE.name(), null, HttpStatus.NOT_FOUND);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        vehicle.setCode(gus.genSecureCode("AP"));
        return repo.save(vehicle);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<Vehicle> findByBrand(String brand) {
        List<Vehicle> vehicles = repo.findTop5ByBrand(brand);
        if (!vehicles.isEmpty())
            return vehicles;
        throw new GUSException(SERVICES.VEHICLE_SERVICE.name(), null,HttpStatus.NOT_FOUND);
    }

    @Override
    public Vehicle findByPlaque(String plaque) {
        Vehicle vehicle = repo.findFirstByPlaqueContains(plaque);
        if (null!=vehicle)
            return vehicle;
        throw new GUSException(SERVICES.VEHICLE_SERVICE.name(), null, HttpStatus.NO_CONTENT);
    }

    @Override
    public Vehicle findByCode(String code) {
        Vehicle vehicle = repo.findFirstByCodeContains(code);
        if (null!=vehicle)
            return vehicle;
        throw new GUSException(SERVICES.VEHICLE_SERVICE.name(), null, HttpStatus.NOT_FOUND);
    }
}
