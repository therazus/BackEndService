package com.WHotels.HotelMIS.controller.resort;


import com.WHotels.HotelMIS.dto.resort.BookingRequest;
import com.WHotels.HotelMIS.dto.resort.BookingResponse;
import com.WHotels.HotelMIS.dto.resort.RoomAvailabilitySearchResponse;
import com.WHotels.HotelMIS.model.resort.RoomType;
import com.WHotels.HotelMIS.service.BookingManagementService;
import com.WHotels.HotelMIS.service.RoomOrderManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/room/booking")
@CrossOrigin
public class RoomOrderManagementController {

    @Autowired
    RoomOrderManagementService roomOrderManagementService;

    @Autowired
    BookingManagementService bookingManagementService;

    @GetMapping("/search-availability")
    ResponseEntity<List<RoomAvailabilitySearchResponse>> checkAvailability(@RequestParam String checkIn, @RequestParam String checkOut, @RequestParam int adultCount, @RequestParam int childrenCount, @RequestParam(required = false) String promo) throws Exception{
        List<RoomAvailabilitySearchResponse> response = roomOrderManagementService.checkAvailability(checkIn, checkOut, adultCount, childrenCount);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<BookingResponse> doBooking(@RequestBody BookingRequest bookingRequest) throws Exception{
        BookingResponse response = bookingManagementService.doBooking(bookingRequest);
        return ResponseEntity.ok(response);
    }

}
