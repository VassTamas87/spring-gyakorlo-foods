package hu.flowacademy.springgyakorlas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orders {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn
    private Users personWhoOrdered;

    @ManyToMany
    @JoinTable(name = "food_orders",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id"))
    private List<Food> foodOrders;
}
