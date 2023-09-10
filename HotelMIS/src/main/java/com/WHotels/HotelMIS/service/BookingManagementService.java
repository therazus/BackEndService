package com.WHotels.HotelMIS.service;

import com.WHotels.HotelMIS.dto.resort.BookingRequest;
import com.WHotels.HotelMIS.dto.resort.BookingResponse;
import com.WHotels.HotelMIS.model.common.Customer;
import com.WHotels.HotelMIS.model.resort.Booking;
import com.WHotels.HotelMIS.model.resort.Room;
import com.WHotels.HotelMIS.repository.common.CustomerRepository;
import com.WHotels.HotelMIS.repository.resort.BookingRepository;
import com.WHotels.HotelMIS.repository.resort.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingManagementService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    BookingRepository bookingRepository;

    public BookingResponse doBooking(BookingRequest bookingRequest) throws Exception{
        try{
            Customer customer = customerMapping(bookingRequest.getCustomerNICNo());
            List<Long> roomIdList = roomRepository.selectARoom(bookingRequest.getCheckIn(), bookingRequest.getCheckOut(), bookingRequest.getRoomType());
            if(roomIdList==null || roomIdList.isEmpty()) throw new Exception("No Rooms Available for this Room Type!");
            Optional<Room> roomOptional = roomRepository.findById(roomIdList.get(0));
            Booking booking = bookingMapping(customer, roomOptional.get(), bookingRequest);
            Booking savedBooking  = bookingRepository.save(booking);

            return BookingResponse.builder().bookingStatus("In Progress").bookingId(savedBooking.getBookingId()).build();


        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    private Booking bookingMapping(Customer customerId, Room room, BookingRequest bookingRequest) throws Exception{
        try{
            Booking booking = new Booking();
            booking.setBookingStatus("In Progress");
            booking.setCheckIn(Date.valueOf(bookingRequest.getCheckIn()));
            booking.setCheckOut(Date.valueOf(bookingRequest.getCheckOut()));
            booking.setCustomer(customerId);
            booking.setRoom(room);
            return booking;
        }catch (Exception ex){
            throw new Exception("Exception in Service Layer");
        }
    }

    private Customer customerMapping(String customerNICNo) throws Exception{
        try{
            Customer customer;
            Long customerId = customerRepository.searchCustomerByNIC(customerNICNo);
            if(customerId==null){
                customer = new Customer();
                customer.setNicNumber(customerNICNo);
            }else {
                Optional<Customer> customerOptional  = customerRepository.findById(customerId);
                if(customerOptional.isPresent()) return customerOptional.get();
                else throw new Exception("Customer Not Found");
            }
            return customer;
        }catch (Exception ex){
            throw new Exception("Customer Not Found");
        }

    }
}
