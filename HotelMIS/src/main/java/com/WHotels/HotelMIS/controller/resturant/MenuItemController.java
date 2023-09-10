package com.WHotels.HotelMIS.controller.resturant;


import com.WHotels.HotelMIS.model.resturant.MenuItem;
import com.WHotels.HotelMIS.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/menuitem")
public class MenuItemController {

    private final MenuItemService menuItemService;

    @Autowired
    MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping
    public List<MenuItem> getMenuItems(){
        return menuItemService.getMenuItems();
    }
    @GetMapping(path="/instock")
    public List<MenuItem> getInStockMenuItems(){
        return menuItemService.getInStockMenuItems();
    }
}


