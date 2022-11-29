package gr.codehub.jpademo.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor

@Data
@MappedSuperclass
@EqualsAndHashCode
@NoArgsConstructor
public class Person extends BaseEntity{

    private String name;
    @Column(unique = true)
    private String emailAddress;
    private int birthYear;
    private LocalDateTime registrationDate;

}
