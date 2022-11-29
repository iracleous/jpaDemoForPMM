package gr.codehub.jpademo.dto;

import gr.codehub.jpademo.model.Product;
import gr.codehub.jpademo.model.ProductCategory;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class ProductDto {
    private int id;
    private String name;
    private BigDecimal price;
    private LocalDate fistLaunchDate;
    private ProductCategory productCategory;

    public ProductDto(Product product){
        id = product.getId();
        name = product.getName();
        price = product.getPrice();
        productCategory = product.getProductCategory();
        fistLaunchDate = product.getFistLaunchDate();
    }

    public Product asProduct(){
        return Product.builder().id(id).name(name).price(price).productCategory(productCategory).fistLaunchDate(fistLaunchDate).build();
    }

}
