package com.canteen.Smart_Canteen.repository;

import com.canteen.Smart_Canteen.model.Order;
import com.canteen.Smart_Canteen.model.Order.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// JpaRepository provides CRUD methods automatically for the Order entity
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Finds orders based on their status (used in OrderService and OrderController)
    List<Order> findByStatus(OrderStatus status);
}