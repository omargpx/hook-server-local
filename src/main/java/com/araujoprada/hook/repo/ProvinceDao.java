package com.araujoprada.hook.repo;

import com.araujoprada.hook.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceDao extends JpaRepository<Province,Integer> {
    Province findFirstByNameContains(String name);
}
