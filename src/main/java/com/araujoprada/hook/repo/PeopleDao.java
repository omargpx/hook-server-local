package com.araujoprada.hook.repo;

import com.araujoprada.hook.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleDao extends JpaRepository<People,Integer> {
    People findFirstByNameContains(String name);
}
