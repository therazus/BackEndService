package com.WHotels.HotelMIS.repository.resort;

import com.WHotels.HotelMIS.model.resort.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query(nativeQuery = true, value = "select * from room r where r.room_id in :roomIds")
    List<Room> findByIds(List<Long> roomIds);

    @Query(nativeQuery = true, value = "select\n" +
            "\tr.room_id \n" +
            "from\n" +
            "\troom r\n" +
            "where\n" +
            "\tr.room_id not in (\n" +
            "\tselect\n" +
            "\t\tb.room_id\n" +
            "\tfrom\n" +
            "\t\tbooking b\n" +
            "\twhere\n" +
            "\t\tb.check_in >= (cast (cast(:checkIn as text) as date))\n" +
            "\t\t\tand b.check_out <=(cast (cast(:checkOut as text) as date)))\n" +
            "\tand r.room_type_id in (\n" +
            "\tselect\n" +
            "\t\trt.room_type_id\n" +
            "\tfrom\n" +
            "\t\troom_type rt\n" +
            "\twhere\n" +
            "\t\trt.\"type\"=:roomType)")
    List<Long> selectARoom(String checkIn, String checkOut, String roomType);


    @Query(nativeQuery = true, value = "select\n" +
            "\t*\n" +
            "from\n" +
            "\troom r\n" +
            "where\n" +
            "\tr.room_id not in (\n" +
            "\tselect\n" +
            "\t\tb.room_id\n" +
            "\tfrom\n" +
            "\t\tbooking b\n" +
            "\twhere\n" +
            "\t\tb.check_in <= (cast (cast(:today as text) as date))\n" +
            "\t\t\tand \n" +
            "b.check_out >= (cast (cast(:today as text) as date))\n" +
            "\t\t\t\tand b.booking_status = 'Confirmed')")
    List<Room> findAvailableRooms(String today);
}
