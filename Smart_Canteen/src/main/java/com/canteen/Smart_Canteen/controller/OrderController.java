package com.canteen.Smart_Canteen.controller;

import com.canteen.Smart_Canteen.model.Order;
import com.canteen.Smart_Canteen.model.Order.OrderStatus;
import com.canteen.Smart_Canteen.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // 1. Customer: Display the order form
    @GetMapping("/new")
    public String showOrderForm(Model model) {
        // Initializes a new Order object for the form
        model.addAttribute("order", new Order());
        return "order"; // Renders order.html
    }

    // 2. Customer: Handles placing a new order
    @PostMapping("/place")
    public String placeOrder(@ModelAttribute Order order, RedirectAttributes redirectAttributes) {
        Order newOrder = orderService.placeOrder(order);

        // Pass success message and ID to the redirect
        redirectAttributes.addFlashAttribute("message", "Order placed successfully! Pickup ID: " + newOrder.getId());
        redirectAttributes.addAttribute("orderId", newOrder.getId());
        return "redirect:/order/confirmation";
    }

    // 3. Customer: Handles order confirmation display (after successful order)
    @GetMapping("/confirmation")
    public String orderConfirmation(@RequestParam(required = false) Long orderId, Model model) {
        if (!model.containsAttribute("message") && orderId != null) {
            model.addAttribute("message", "Order confirmed. Your Pickup ID is: " + orderId);
        } else if (orderId == null) {
            model.addAttribute("message", "Order confirmed. Thank you!");
        }
        return "confirmation"; // Renders confirmation.html
    }


    // 4. Staff: View for Pickup Management
    @GetMapping("/pickup")
    public String viewPickupQueue(Model model) {
        model.addAttribute("pendingOrders", orderService.findOrdersByStatus(OrderStatus.PENDING));
        model.addAttribute("readyOrders", orderService.findOrdersByStatus(OrderStatus.READY));
        return "pickup"; // Renders pickup.html
    }

    // 5. Staff: Action to update an order status
    @PostMapping("/status/{id}")
    public String updateStatus(@PathVariable Long id, @RequestParam String action) {
        if ("ready".equals(action)) {
            orderService.updateOrderStatus(id, OrderStatus.READY);
        } else if ("picked_up".equals(action)) {
            orderService.updateOrderStatus(id, OrderStatus.PICKED_UP);
        }
        return "redirect:/order/pickup";
    }
}