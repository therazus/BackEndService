package com.WHotels.HotelMIS.repository.resort;


import com.WHotels.HotelMIS.model.resort.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {


}
