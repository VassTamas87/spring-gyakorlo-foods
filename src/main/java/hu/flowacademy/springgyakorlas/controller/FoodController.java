package hu.flowacademy.springgyakorlas.controller;

import hu.flowacademy.springgyakorlas.model.Food;
import hu.flowacademy.springgyakorlas.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/foods")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @GetMapping
    public List<Food> findAll() {
        return foodService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Food> findOne(@PathVariable Integer id) {
        return foodService.findOne(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Food update(@RequestBody Food food, @PathVariable Integer id) {
        return foodService.update(food, id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Food save(@RequestBody Food food) {
        return foodService.save(food);
    }
}
