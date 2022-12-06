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

public class Order extends BaseEntity {

    private LocalDateTime date;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Customer secondCustomer;
    @ManyToOne
    private Employee employee;
}
