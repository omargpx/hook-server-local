package com.araujoprada.hook.service;

import com.araujoprada.hook.entity.Vehicle;
import java.util.List;

public interface VehicleService {
    List<Vehicle> getAll();
    Vehicle getById(int id);
    Vehicle save(Vehicle vehicle);
    void delete(int id);

    //region filter vehicles
    List<Vehicle> findByBrand(String brand);
    Vehicle findByPlaque(String plaque);
    Vehicle findByCode(String code);
    //endregion
}
