package com.WHotels.HotelMIS.dto.resort;


import com.WHotels.HotelMIS.model.resort.RoomType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class RoomAvailabilitySearchResponse {
    private Map<RoomType,Integer> roomTypeIntegerMap;
}
