package hu.flowacademy.springgyakorlas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {

    @Id
    private Integer id;
    private String email;
    private String fullAddress;

    @JsonIgnore
    @OneToMany(mappedBy = "personWhoOrdered")
    List<Orders> orders;
}
