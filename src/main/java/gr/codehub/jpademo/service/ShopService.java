package gr.codehub.jpademo.service;

import gr.codehub.jpademo.dto.ProductDto;
import gr.codehub.jpademo.dto.ResultApi;
import gr.codehub.jpademo.exception.ProductNotFoundException;
import gr.codehub.jpademo.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ShopService {

    ResultApi<ProductDto> findProductAsResult(int productId);

    ProductDto createProduct(ProductDto product);
    ProductDto findProduct(int productId) throws ProductNotFoundException;
    List<ProductDto> findProducts(Integer pageCount, Integer pageSize);
    ProductDto updateProduct(int productId, ProductDto product);
    boolean deleteProduct(int productId);

    List<Double> findPrices();
    List<ProductDto> findProductByNameAndByPrice(BigDecimal maximumPrice, String productName);
}
