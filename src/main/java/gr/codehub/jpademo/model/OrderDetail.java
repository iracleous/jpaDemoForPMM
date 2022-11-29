package gr.codehub.jpademo.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
public class OrderDetail extends BaseEntity {

    private int quantity;
    private BigDecimal finalPrice;

    @ManyToOne
    private Order order;
    @ManyToOne
    private  Product product;

}
