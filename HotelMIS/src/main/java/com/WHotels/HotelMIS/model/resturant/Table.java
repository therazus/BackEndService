package com.WHotels.HotelMIS.model.resturant;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@jakarta.persistence.Table(name="restaurant_table")
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="table_id")
    private long id;
    @Column(name="occupied", columnDefinition = "boolean default false")
    private boolean occupied;
    @Column(name="waiter_requested", columnDefinition = "boolean default false")
    private boolean waiterRequested;
    @Column(name="reserved", columnDefinition = "boolean default false")
    private boolean reserved;

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", occupied=" + occupied +
                ", waiterRequested=" + waiterRequested +
                ", reserved=" + reserved +
                '}';
    }
}

