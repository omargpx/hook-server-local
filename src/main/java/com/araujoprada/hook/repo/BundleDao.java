package com.araujoprada.hook.repo;

import com.araujoprada.hook.entity.Bundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BundleDao extends JpaRepository<Bundle,Integer> {
    @Query("SELECT b FROM Bundle b WHERE b.execution BETWEEN :date_init AND :date_end AND b.end IS NULL")
    List<Bundle> findByExecutionBetween(@Param("date_init") LocalDate dateInit, @Param("date_end") LocalDate dateEnd);
}
