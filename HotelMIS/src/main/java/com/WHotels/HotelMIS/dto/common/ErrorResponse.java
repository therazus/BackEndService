package com.WHotels.HotelMIS.dto.common;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ErrorResponse {
    private String errorMsg;
}
