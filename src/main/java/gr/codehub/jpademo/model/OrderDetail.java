package gr.codehub.jpademo.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private BigDecimal finalPrice;

    @ManyToOne
    private Order order;
    @ManyToOne
    private  Product product;

}
