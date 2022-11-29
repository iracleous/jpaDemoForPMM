package gr.codehub.jpademo.model;



import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime signDate;
    @ManyToOne
    private Customer customer;


}
