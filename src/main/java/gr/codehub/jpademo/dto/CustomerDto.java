package gr.codehub.jpademo.dto;

import gr.codehub.jpademo.model.Customer;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class CustomerDto {
    private long id;
    private String name;
    private String emailAddress;
    private int birthYear;
    private LocalDateTime registrationDate;

    public CustomerDto( Customer customer){
        id = customer.getId();
        name = customer.getName();
        emailAddress = customer.getEmailAddress();
        birthYear = customer.getBirthYear();
        registrationDate = customer.getRegistrationDate();
    }

    public Customer asCustomer(){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setEmailAddress(emailAddress);
        customer.setBirthYear(birthYear);
        customer.setRegistrationDate(registrationDate);
        return customer;
    }

}
