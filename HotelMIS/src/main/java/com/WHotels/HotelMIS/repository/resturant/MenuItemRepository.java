package com.WHotels.HotelMIS.repository.resturant;

import com.WHotels.HotelMIS.model.resturant.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    @Query(value = "SELECT * FROM menu_item ORDER BY menuitem_id ASC", nativeQuery = true)
    List<MenuItem> findByOrderByIdAsc();

//    @Query("SELECT * FROM menu_item m WHERE m.quantity > 0")
//    List<MenuItem> findInStockMenuItems();
}
