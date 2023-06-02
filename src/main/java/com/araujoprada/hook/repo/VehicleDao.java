package com.araujoprada.hook.repo;

import com.araujoprada.hook.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleDao extends JpaRepository<Vehicle,Integer> {
    Vehicle findFirstByCodeContains(String code);
    Vehicle findFirstByPlaqueContains(String plaque);
    List<Vehicle> findTop5ByBrand(String brand);
}
