package gr.codehub.jpademo.service;

import gr.codehub.jpademo.dto.OrderDto;
import gr.codehub.jpademo.dto.ProductDto;
import gr.codehub.jpademo.dto.ResultApi;
import gr.codehub.jpademo.exception.CustomerNotFoundException;
import gr.codehub.jpademo.exception.ProductNotFoundException;
import gr.codehub.jpademo.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ShopService {

    ResultApi<ProductDto> findProductAsResult(long productId);

    ProductDto createProduct(ProductDto product);
    ProductDto findProduct(long productId) throws ProductNotFoundException;
    List<ProductDto> findProducts(Integer pageCount, Integer pageSize);
    ProductDto updateProduct(long productId, ProductDto product);
    boolean deleteProduct(long productId);

    List<Double> findPrices();
    List<ProductDto> findProductByNameAndByPrice(BigDecimal maximumPrice, String productName);

    OrderDto createOrder(long customerId1, long customerId2) throws CustomerNotFoundException;
}
