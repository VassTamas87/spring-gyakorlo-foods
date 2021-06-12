package hu.flowacademy.springgyakorlas.repository;

import hu.flowacademy.springgyakorlas.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
