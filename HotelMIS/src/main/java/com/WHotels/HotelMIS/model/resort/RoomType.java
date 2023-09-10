package com.WHotels.HotelMIS.model.resort;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Data
@Entity
@Getter
@Setter
@ToString
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_type_id")
    private Long roomTypeId;

    @Column(nullable = false)
    private String type;

    @Column(name = "max_adult_occupancy", nullable = false)
    private Integer maxAdultOccupancy;

    @Column(name = "max_child_occupancy", nullable = false)
    private Integer maxChildOccupancy;

    @Column
    private Integer roomSize;

    @Column
    private String description;

    @Column(name = "room_price", nullable = false)
    private Long roomPrice;


}

