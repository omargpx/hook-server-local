package com.araujoprada.hook.repo;

import com.araujoprada.hook.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictDao extends JpaRepository<District,Integer> {
    District findFirstByNameContains(String name);
}
