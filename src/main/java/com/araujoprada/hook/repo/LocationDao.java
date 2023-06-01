package com.araujoprada.hook.repo;

import com.araujoprada.hook.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationDao extends JpaRepository<Location,Integer> {
}
