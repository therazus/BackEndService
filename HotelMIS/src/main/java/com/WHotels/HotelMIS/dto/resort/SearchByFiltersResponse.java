package com.WHotels.HotelMIS.dto.resort;


import com.WHotels.HotelMIS.model.common.Customer;
import com.WHotels.HotelMIS.model.resort.Room;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class SearchByFiltersResponse {
    private  Long bookingId;
    private String checkIn;
    private String checkOut;
    private String bookingStatus;
    private String firstName;
    private String lastName;
}
