package com.example.springboot18.service;

import com.example.springboot18.dao.IOrdersDao;
import com.example.springboot18.model.Orders;
import com.example.springboot18.view.orders.OrdersView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    public List<OrdersView> show(Orders orders) {
        List<OrdersView> ordersViews = ordersDao.show(orders);
        return ordersViews;
    }
}