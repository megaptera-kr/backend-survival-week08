package kr.megaptera.assignment.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    public String getOrders(@RequestAttribute String userId) {
        return "Order List of User " + userId + " is loaded.";
    }

    @PostMapping
    public String requestOrder(@RequestAttribute String userId, @RequestBody List<String> carts) {
        return "Items in cart" + carts.toString() + " are ordered by User " + userId + ".";
    }

}
