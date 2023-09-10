package com.WHotels.HotelMIS.repository.common;

import com.WHotels.HotelMIS.model.common.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
