package gr.codehub.jpademo.model;



import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
public class Contract extends BaseEntity{

    private LocalDateTime signDate;
    @ManyToOne
    private Customer customer;


}
