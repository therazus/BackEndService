package com.WHotels.HotelMIS.controller.resort;

import com.WHotels.HotelMIS.dto.resort.AppHomeResponse;
import com.WHotels.HotelMIS.dto.resort.RoomAvailabilitySearchResponse;
import com.WHotels.HotelMIS.dto.resort.SearchByFiltersResponse;
import com.WHotels.HotelMIS.model.resort.Booking;
import com.WHotels.HotelMIS.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
@CrossOrigin
public class AppController {

    @Autowired
    AppService appService;

    @GetMapping("/home")
    ResponseEntity<AppHomeResponse> getHomeScreen() throws Exception{
        AppHomeResponse response = appService.getHomeScreen();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/booking")
    ResponseEntity<List<SearchByFiltersResponse>> getBookingDetailsByFilters(@RequestParam(required = false) Long bookingId, @RequestParam(required = false)String customerName) throws Exception{
        List<SearchByFiltersResponse> response = appService.getBookingDetailsByFilters(bookingId, customerName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // create booking - /room/booking - POST



}
