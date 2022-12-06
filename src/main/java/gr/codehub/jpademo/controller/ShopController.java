package gr.codehub.jpademo.controller;


import gr.codehub.jpademo.dto.OrderDto;
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

    @GetMapping("/")
    public String home(){
        return "PMM Rest API";
    }


    @GetMapping("productAsResult/{id}")
    public ResultApi<ProductDto> getCustomerAsResult(@PathVariable long id)    {
        return   shopService.findProductAsResult(id);
    }

    @GetMapping("product/{id}")
    public ProductDto getCustomer(@PathVariable long id)  throws ProductNotFoundException {
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
    public List<ProductDto> productsByPrice(@RequestParam (name="price", required = false) BigDecimal price,
                                            @RequestParam(name="name") String name){
        return shopService.findProductByNameAndByPrice(price, name);
    }


    @PostMapping("/order/customer1/{customerId1}/customer2/{customerId2}")
     public OrderDto createOrder(@PathVariable(name="customerId1") long customerId1,  @PathVariable(name="customerId2") long customerId2)
    throws CustomerNotFoundException    {
        return shopService.createOrder(customerId1, customerId2);
    }
}
