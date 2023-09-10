package com.WHotels.HotelMIS.model.resturant;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
public class MenuItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "menu_item_id")
    private long menuItemId;
    @Basic
    @Column(name = "food_type")
    private String foodType;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;
    @Basic
    @Column(name = "price")
    private BigDecimal price;
    @Basic
    @Column(name = "discount")
    private BigDecimal discount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuitem = (MenuItem) o;
        return menuItemId == menuitem.menuItemId && Objects.equals(foodType, menuitem.foodType) && Objects.equals(name, menuitem.name) && Objects.equals(quantity, menuitem.quantity) && Objects.equals(price, menuitem.price) && Objects.equals(discount, menuitem.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuItemId, foodType, name, quantity, price, discount);
    }
}
