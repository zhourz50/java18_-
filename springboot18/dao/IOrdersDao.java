package com.example.springboot18.dao;

import com.example.springboot18.model.Orders;
import com.example.springboot18.view.orders.OrdersView;

import java.util.List;

public interface IOrdersDao {
    List<OrdersView> show(Orders orders);

}

