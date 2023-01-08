package com.example.springboot18.controller.orders;

import com.example.springboot18.model.Orders;
import com.example.springboot18.service.OrdersService;
import com.example.springboot18.view.ResultView;
import com.example.springboot18.view.orders.OrdersView;
import com.example.springboot18.vo.orders.OrdersQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v2/orders/")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping
    public ResultView<List<OrdersView>> orders(@Valid OrdersQueryVo vo) {
        Orders orders = vo.transferToModel();
        List<OrdersView> ordersViews = ordersService.show(orders);//获取订单
        return ResultView.success(ordersViews);
    }

}

