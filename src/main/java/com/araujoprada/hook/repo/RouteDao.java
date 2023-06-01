package com.araujoprada.hook.repo;

import com.araujoprada.hook.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteDao extends JpaRepository<Route,Integer> {
    Route findFirstByCodeContains(String code);
}
