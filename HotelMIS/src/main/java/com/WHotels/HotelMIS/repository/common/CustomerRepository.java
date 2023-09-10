package com.WHotels.HotelMIS.repository.common;

import com.WHotels.HotelMIS.model.common.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(nativeQuery = true, value = "select customer_id from customer c where c.name = :customerNICNo")
    Long searchCustomerByNIC(String customerNICNo);

    @Query(nativeQuery = true, value = "select * from customer c where c.nic_number = :nicNo")
    List<Customer> findByNICNo(String nicNo);
}
