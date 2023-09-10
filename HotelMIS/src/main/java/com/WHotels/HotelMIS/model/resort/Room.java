package com.WHotels.HotelMIS.model.resort;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;

    private String roomStatus;

    @ManyToOne
    @JoinColumn(name = "room_type_id", referencedColumnName = "room_type_id")
    private RoomType roomType;
}

