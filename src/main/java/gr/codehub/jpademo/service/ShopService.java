package gr.codehub.jpademo.service;

import gr.codehub.jpademo.dto.ProductDto;
import gr.codehub.jpademo.dto.ResultApi;
import gr.codehub.jpademo.exception.ProductNotFoundException;
import gr.codehub.jpademo.model.Product;

import java.util.List;

public interface ShopService {

    ResultApi<ProductDto> findProductAsResult(int productId);

    ProductDto createProduct(ProductDto product);
    ProductDto findProduct(int productId) throws ProductNotFoundException;
    List<ProductDto> findProducts();
    ProductDto updateProduct(int productId, ProductDto product);
    boolean deleteProduct(int productId);
}
