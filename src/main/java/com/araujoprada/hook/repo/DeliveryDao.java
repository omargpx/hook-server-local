package com.araujoprada.hook.repo;

import com.araujoprada.hook.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryDao extends JpaRepository<Delivery,Integer> {
}
