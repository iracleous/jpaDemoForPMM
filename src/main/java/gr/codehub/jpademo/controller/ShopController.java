package gr.codehub.jpademo.controller;


import gr.codehub.jpademo.dto.ProductDto;
import gr.codehub.jpademo.dto.ResultApi;
import gr.codehub.jpademo.exception.CustomerNotFoundException;
import gr.codehub.jpademo.exception.ProductNotFoundException;
import gr.codehub.jpademo.service.ShopService;
import jakarta.persistence.Entity;
import jakarta.websocket.server.PathParam;
import lombok.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
public class ShopController {
    private ShopService shopService;

    @GetMapping("productAsResult/{id}")
    public ResultApi<ProductDto> getCustomerAsResult(@PathVariable int id)    {
        return   shopService.findProductAsResult(id);
    }

    @GetMapping("product/{id}")
    public ProductDto getCustomer(@PathVariable int id)  throws ProductNotFoundException {
        return shopService.findProduct(id);
    }
    @GetMapping("product")
    public List<ProductDto> getCustomers(
            @RequestParam (name="page", required = false) Integer pageCount,
            @RequestParam (name="size", required = false) Integer pageSize  )  {

        return shopService.findProducts(pageCount, pageSize);
    }
    @PostMapping("product")
    public ProductDto createCustomer(@RequestBody ProductDto productDto)   {
        return shopService.createProduct(productDto) ;
    }

    @GetMapping("prices")
    public List<Double> getPrices(){
        return shopService.findPrices();
    }

    @GetMapping("productByPrice")
    public List<ProductDto> productsByPrice(@RequestParam (name="price", required = false) BigDecimal price, @RequestParam(name="name") String name){
        return shopService.findProductByNameAndByPrice(price, name);
    }


}
