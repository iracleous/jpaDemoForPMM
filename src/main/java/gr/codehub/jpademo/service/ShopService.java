package gr.codehub.jpademo.service;

import gr.codehub.jpademo.dto.ProductDto;
import gr.codehub.jpademo.model.Product;

import java.util.List;

public interface ShopService {
    ProductDto createProduct(ProductDto product);
    ProductDto findProduct(int productId);
    List<ProductDto> findProducts();
    ProductDto updateProduct(int productId, ProductDto product);
    boolean deleteProduct(int productId);
}
