package hu.flowacademy.springgyakorlas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Food {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private double price;

    @JsonIgnore
    @ManyToMany(mappedBy = "foodOrders")
    private List<Orders> orders;
}
