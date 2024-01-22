package com.devsuperior.desafio01.service;

import com.devsuperior.desafio01.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order){
        double discount = (order.getDiscount()/100) * order.getBasic();
        double price = order.getBasic() - discount;

        return price + shippingService.shipping(order);
    }

}
