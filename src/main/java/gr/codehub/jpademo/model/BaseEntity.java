package gr.codehub.jpademo.model;


import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor

@Data
@MappedSuperclass
@EqualsAndHashCode
@NoArgsConstructor

public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
