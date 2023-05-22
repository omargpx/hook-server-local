package com.araujoprada.hook.repo;

import com.araujoprada.hook.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessDao extends JpaRepository<Business,Integer> {
}
