package com.araujoprada.hook.repo;

import com.araujoprada.hook.entity.Bundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BundleDao extends JpaRepository<Bundle,Integer> {
}
