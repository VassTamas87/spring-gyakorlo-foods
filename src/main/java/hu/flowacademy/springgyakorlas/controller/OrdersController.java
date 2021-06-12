package hu.flowacademy.springgyakorlas.controller;

import hu.flowacademy.springgyakorlas.model.Orders;
import hu.flowacademy.springgyakorlas.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Orders save(@RequestBody Orders order) {
        return ordersService.save(order);
    }

    @GetMapping
    public List<Orders> findAll() {
        return ordersService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Orders> findOne(@PathVariable Integer id) {
        return ordersService.findOne(id);
    }
}
