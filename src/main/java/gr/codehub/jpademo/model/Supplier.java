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
public class Supplier extends Person{


    @OneToMany (mappedBy = "supplier")
    private List<Product> products;
}
