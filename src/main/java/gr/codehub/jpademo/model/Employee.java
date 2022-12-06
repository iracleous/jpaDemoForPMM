package gr.codehub.jpademo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor

public class Employee extends Person {


    @OneToMany(mappedBy = "employee")
    private List<Order> orders;
    @ManyToOne
    private Employee manager ;
    @OneToMany(mappedBy = "manager")
    private List<Employee> subordinates;
}