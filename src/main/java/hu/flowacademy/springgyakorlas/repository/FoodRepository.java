package hu.flowacademy.springgyakorlas.repository;

import hu.flowacademy.springgyakorlas.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
}
