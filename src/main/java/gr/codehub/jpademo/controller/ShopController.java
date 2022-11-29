package gr.codehub.jpademo.controller;


import gr.codehub.jpademo.dto.ProductDto;
import gr.codehub.jpademo.exception.CustomerNotFoundException;
import gr.codehub.jpademo.exception.ProductNotFoundException;
import gr.codehub.jpademo.service.ShopService;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ShopController {
    private ShopService shopService;

    @GetMapping("product/{id}")
    public ProductDto getCustomer(@PathVariable int id)   throws ProductNotFoundException {
        return shopService.findProduct(id);
    }
    @GetMapping("product")
    public List<ProductDto> getCustomers()   throws ProductNotFoundException {
        return shopService.findProducts();
    }
    @PostMapping("product")
    public ProductDto createCustomer(@RequestBody ProductDto productDto)   throws ProductNotFoundException {
        return shopService.createProduct(productDto) ;
    }
}
