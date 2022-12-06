package gr.codehub.jpademo.dto;

import gr.codehub.jpademo.model.Order;
import gr.codehub.jpademo.model.Product;

import java.time.LocalDateTime;

public class OrderDto {
    private int id;
    private LocalDateTime date;

    public OrderDto(Order order){
        id = order.getId();
        date = order.getDate();
    }

    public Order asProduct(){
        Order order = new Order();
        order.setId(id);
        order.setDate(date);
        return order;
    }
}
