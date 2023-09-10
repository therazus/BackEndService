package com.WHotels.HotelMIS.model.resturant;
import com.WHotels.HotelMIS.model.common.Customer;
import com.WHotels.HotelMIS.model.resort.Room;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;

@Entity
@Getter
@Setter
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long reservationId;
    @Column(name = "date")
    private java.sql.Date date;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "duration")
    private java.time.Duration duration;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "table_id", referencedColumnName = "table_id")
    private Table table;
}

