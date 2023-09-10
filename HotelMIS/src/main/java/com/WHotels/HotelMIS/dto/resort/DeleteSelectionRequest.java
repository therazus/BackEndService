package com.WHotels.HotelMIS.dto.resort;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class DeleteSelectionRequest {
    private List<Long> bookingIdList;
}
