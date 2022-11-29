package gr.codehub.jpademo.service;


import gr.codehub.jpademo.dto.ProductDto;
import gr.codehub.jpademo.model.Product;
import gr.codehub.jpademo.repository.ProductRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ShopServiceImpl implements ShopService {
    private ProductRepository productRepository;


    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productDto.asProduct();
        productRepository.save(product);
        return new ProductDto(product);
    }

    @Override
    public ProductDto findProduct(int productId) {
        return new ProductDto(productRepository.findById(productId).get()) ;
    }

    @Override
    public List<ProductDto> findProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductDto::new).collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(int productId, ProductDto product) {
        return null;
    }

    @Override
    public boolean deleteProduct(int productId) {
        return false;
    }
}
