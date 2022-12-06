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
    private long id;
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
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setProductCategory(productCategory);
        product.setFistLaunchDate(fistLaunchDate);
        return product;
      }

}
