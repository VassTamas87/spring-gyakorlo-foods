package hu.flowacademy.springgyakorlas.service;

import hu.flowacademy.springgyakorlas.exception.ValidateException;
import hu.flowacademy.springgyakorlas.model.Food;
import hu.flowacademy.springgyakorlas.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    public Optional<Food> findOne(int id) {
        return foodRepository.findById(id);
    }

    public Food update(Food food, int id) {
        validate(food.toBuilder().id(id).build());
        return foodRepository.save(food.toBuilder().id(id).build());
    }

    public Food save(Food food) {
        validate(food);
        return foodRepository.save(food);
    }

    public void validate(Food food) {
        if (food.getName() == null || food.getName().equals("")) {
            throw new ValidateException("nem adtál meg nevet!!!");
        }
        if (food.getPrice() < 0) {
            throw new ValidateException("nem lehet az ár kevesebb!!!");
        }
    }
}
