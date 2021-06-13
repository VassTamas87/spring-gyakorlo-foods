package hu.flowacademy.springgyakorlas.service;

import hu.flowacademy.springgyakorlas.exception.ValidateException;
import hu.flowacademy.springgyakorlas.model.Orders;
import hu.flowacademy.springgyakorlas.model.Users;
import hu.flowacademy.springgyakorlas.repository.FoodRepository;
import hu.flowacademy.springgyakorlas.repository.OrdersRepository;
import hu.flowacademy.springgyakorlas.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final UserRepository userRepository;
    private final FoodRepository foodRepository;

    public Orders save(Orders order) {
        validate(order);
        Users user;
        if (userRepository.findById(order.getPersonWhoOrdered().getId()).equals(Optional.empty())) {
            user = userRepository.save(order.getPersonWhoOrdered().toBuilder().build());
        } else {
            user = userRepository.findById(order.getPersonWhoOrdered().getId()).orElseThrow();
            if (!order.getPersonWhoOrdered().getEmail().equals(user.getEmail())) {
                throw new ValidateException("Nem egyezik az emial cím!!!");
            }
            if (!order.getPersonWhoOrdered().getFullAddress().equals(user.getFullAddress())) {
                throw new ValidateException("Nem egyezik a cím!!!");
            }
        }
        return ordersRepository.save(order.toBuilder().personWhoOrdered(user).foodOrders(order.getFoodOrders()).build());
    }

    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    public Optional<Orders> findOne(int id) {
        return ordersRepository.findById(id);
    }

    public void validate(Orders order) {
        if (order.getFoodOrders() == null || order.getFoodOrders().size() == 0) {
            throw new ValidateException("nem adtál meg ételeket");
        }
        if (order.getPersonWhoOrdered() == null) {
            throw new ValidateException("nincs megrendelő!!!");
        }
        if (order.getFoodOrders().stream().anyMatch(el -> el.getId() == null)) {
            throw new ValidateException("hiányzik az id!!!");
        }
        if (order.getFoodOrders().stream().anyMatch(el -> !foodRepository.existsById(el.getId()))) {
            throw new ValidateException("nincs ilyen étel!!!");
        }
    }
}






