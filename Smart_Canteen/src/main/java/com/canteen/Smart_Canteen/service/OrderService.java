package com.canteen.Smart_Canteen.service;

import com.canteen.Smart_Canteen.model.Order;
import com.canteen.Smart_Canteen.model.Order.OrderStatus;
import com.canteen.Smart_Canteen.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order placeOrder(Order order) {
        // Here you would check stock, calculate total price, etc.
        return orderRepository.save(order);
    }

    public List<Order> findOrdersByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status);
    }

    public void updateOrderStatus(Long orderId, OrderStatus newStatus) {
        orderRepository.findById(orderId).ifPresent(order -> {
            order.setStatus(newStatus);
            orderRepository.save(order);
        });
    }
}