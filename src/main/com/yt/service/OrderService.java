package com.yt.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public String buy(String orderId){
        return "订单id=====" + orderId;
    }
}
