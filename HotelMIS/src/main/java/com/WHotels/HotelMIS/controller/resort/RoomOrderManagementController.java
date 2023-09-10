package com.WHotels.HotelMIS.controller.resort;


import com.WHotels.HotelMIS.dto.resort.RoomAvailabilitySearchResponse;
import com.WHotels.HotelMIS.service.RoomOrderManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/room/booking")
public class RoomOrderManagementController {

    @Autowired
    RoomOrderManagementService roomOrderManagementService;

    @GetMapping("/search-availability")
    ResponseEntity<RoomAvailabilitySearchResponse> checkAvailability(@RequestParam String checkIn, @RequestParam String checkOut, @RequestParam int adultCount, @RequestParam int childrenCount) throws Exception{
        RoomAvailabilitySearchResponse response = roomOrderManagementService.checkAvailability(checkIn, checkOut, adultCount, childrenCount);
        return ResponseEntity.ok(response);
    }

}
