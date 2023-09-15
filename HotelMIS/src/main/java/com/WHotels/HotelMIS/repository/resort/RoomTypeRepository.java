package com.WHotels.HotelMIS.repository.resort;


import com.WHotels.HotelMIS.model.resort.Room;
import com.WHotels.HotelMIS.model.resort.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {




}
