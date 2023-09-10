package com.WHotels.HotelMIS.repository.resturant;


import com.WHotels.HotelMIS.model.resturant.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
