package com.WHotels.HotelMIS.service;

import com.WHotels.HotelMIS.model.resturant.MenuItem;
import com.WHotels.HotelMIS.repository.resturant.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItem> getMenuItems(){
        return menuItemRepository.findByOrderByIdAsc();
    }

    public List<MenuItem> getInStockMenuItems(){
//        return menuItemRepository.findInStockMenuItems();
        return null;
    }
}
