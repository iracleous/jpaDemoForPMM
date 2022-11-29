package gr.codehub.jpademo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
public class Customer extends Person {


    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;


}
