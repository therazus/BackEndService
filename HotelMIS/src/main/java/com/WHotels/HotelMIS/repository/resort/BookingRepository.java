package com.WHotels.HotelMIS.repository.resort;

import com.WHotels.HotelMIS.model.resort.Booking;
import com.WHotels.HotelMIS.model.resort.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

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
            "\t\trt.max_adult_occupancy >=:adultCount\n" +
            "\t\tand rt.max_child_occupancy >=:childrenCount)")
    List<Long> searchAvailability(String checkIn, String checkOut, int childrenCount, int adultCount);


    @Query(nativeQuery = true, value = "select sum(b.total) from booking b where customer_id =:customerId and booking_status = 'Confirmed'")
    Long findTotalSum(Integer customerId);
}
