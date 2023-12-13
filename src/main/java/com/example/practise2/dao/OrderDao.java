package com.example.practise2.dao;

import com.example.practise2.Dao;
import com.example.practise2.model.OrderModel;
import com.example.practise2.model.ProductModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDao implements Dao<OrderModel> {
    private static int ORDER_COUNT;
    private List<OrderModel> orders = new ArrayList<>();
    @Override
    public OrderModel show(int id) {
        return orders.stream().filter(orderModel -> orderModel.getId() == id).findAny().orElse(null);
    }

    @Override
    public List<OrderModel> index() {
        return orders;
    }

    @Override
    public void save(OrderModel orderModel) {
        orderModel.setId(++ORDER_COUNT);
        orders.add(orderModel);
    }

    @Override
    public void update(OrderModel orderModel, int id) {
        OrderModel updatedOrder = show(id);
        updatedOrder.setCustomerName(orderModel.getCustomerName());
        updatedOrder.setProduct(orderModel.getProduct());
        updatedOrder.setQuantity(orderModel.getQuantity());
    }

    @Override
    public void delete(int id) {
        orders.removeIf(o -> o.getId() == id);
    }
}
