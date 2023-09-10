package com.WHotels.HotelMIS.dto.resort;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class BookingResponse {
    private Long bookingId;
    private String bookingStatus;
}
