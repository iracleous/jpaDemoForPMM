package gr.codehub.jpademo.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.SpringApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private BigDecimal price;
    private LocalDate fistLaunchDate;

    private ProductCategory productCategory;

    @ManyToOne
    private Supplier supplier;
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;
}
