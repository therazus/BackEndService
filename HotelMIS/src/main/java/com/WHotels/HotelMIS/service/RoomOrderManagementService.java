package com.WHotels.HotelMIS.service;


import com.WHotels.HotelMIS.dto.resort.RoomAvailabilitySearchResponse;
import com.WHotels.HotelMIS.model.resort.Room;
import com.WHotels.HotelMIS.model.resort.RoomType;
import com.WHotels.HotelMIS.repository.resort.BookingRepository;
import com.WHotels.HotelMIS.repository.resort.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoomOrderManagementService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    RoomRepository roomRepository;
    public RoomAvailabilitySearchResponse checkAvailability(String checkIn, String checkOut, int adultCount, int childrenCount) throws Exception{
        try{
            Map<RoomType,Integer> roomTypeIntegerMap = new HashMap<>();
            List<Long> availableRoomIdList = bookingRepository.searchAvailability(checkIn, checkOut, childrenCount, adultCount);
            List<Room> availableRoomList = roomRepository.findByIds(availableRoomIdList);
            for (Room room: availableRoomList){
                if(roomTypeIntegerMap.containsKey(room.getRoomType())){
                    Integer count = roomTypeIntegerMap.get(room.getRoomType());
                    roomTypeIntegerMap.put(room.getRoomType(), count+1);
                }else {
                    roomTypeIntegerMap.put(room.getRoomType(), 1);
                }
            }

            RoomAvailabilitySearchResponse roomAvailabilitySearchResponse = new RoomAvailabilitySearchResponse();
            roomAvailabilitySearchResponse.setRoomTypeIntegerMap(roomTypeIntegerMap);
            return  roomAvailabilitySearchResponse;



        }catch (Exception ex){
            //ignored
            return null;
        }

    }
}
