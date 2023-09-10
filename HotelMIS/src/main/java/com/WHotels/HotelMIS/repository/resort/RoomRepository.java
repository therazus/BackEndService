package com.WHotels.HotelMIS.repository.resort;

import com.WHotels.HotelMIS.model.resort.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query(nativeQuery = true, value = "select * from room r where r.room_id in :roomIds")
    List<Room> findByIds(List<Long> roomIds);
}
