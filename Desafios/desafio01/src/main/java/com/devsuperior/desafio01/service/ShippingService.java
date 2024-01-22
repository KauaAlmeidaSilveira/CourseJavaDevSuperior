package com.devsuperior.desafio01.service;

import com.devsuperior.desafio01.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipping(Order order){
        double vlrBasic = order.getBasic();

        if (vlrBasic < 100){
            return 20.0;
        } else if (vlrBasic >=100 && vlrBasic <= 200) {
            return 12.0;
        }else {
            return 0.0;
        }

    }

}
