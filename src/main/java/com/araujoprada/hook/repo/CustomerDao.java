package com.araujoprada.hook.repo;

import com.araujoprada.hook.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer> {
    List<Customer> findTop5ByNameContains(String name);
    List<Customer> findByStatusSale(boolean statusSale);
    Customer findByIdentification(String identification);

    @Query(value = "SELECT C.* FROM  TAX_ROUTES R JOIN TMA_CUSTOMERS C ON C.id_cus_routes=R.id_route WHERE R.co_route=:code AND C.es_sale=:status", nativeQuery = true)
    List<Customer> filterCustomerByRoutes(@Param("code")String code,@Param("status")boolean status);
}
