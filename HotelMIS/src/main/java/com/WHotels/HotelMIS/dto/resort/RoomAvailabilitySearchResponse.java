package com.WHotels.HotelMIS.dto.resort;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class RoomAvailabilitySearchResponse {
    private String roomType;
    private Integer maxNoOfAdults;
    private Integer maxNoOfChildren;
    private String description;
    private String price;
    private Integer count;
}
