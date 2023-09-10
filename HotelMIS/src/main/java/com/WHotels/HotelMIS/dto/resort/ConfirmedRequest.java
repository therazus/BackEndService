package com.WHotels.HotelMIS.dto.resort;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ConfirmedRequest {
    private List<Long> bookingIdList;
    private String firstName;
    private String lastName;
    private String nicNo;
    private String phoneNo;
    private String dateOfBirth;
}
