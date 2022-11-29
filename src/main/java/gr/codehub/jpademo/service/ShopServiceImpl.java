package gr.codehub.jpademo.service;


import gr.codehub.jpademo.dto.ProductDto;
import gr.codehub.jpademo.dto.ResultApi;
import gr.codehub.jpademo.exception.ProductNotFoundException;
import gr.codehub.jpademo.model.Product;
import gr.codehub.jpademo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShopServiceImpl implements ShopService {
    private ProductRepository productRepository;


    @Override
    public ResultApi<ProductDto> findProductAsResult(int productId) {
         Optional<Product> productOpt = productRepository .findById(productId);
         if(productOpt.isPresent()) {
             return new ResultApi<ProductDto>(
                     new ProductDto(productOpt.get()) , 0, "");
         }
         else
             return new ResultApi<ProductDto>(null, -1,"Product not found");
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {

        Product product = productDto.asProduct();
        productRepository.save(product);
        return new ProductDto(product);
    }

    /**
     * @param productId
     * @return the request product
     * @throws ProductNotFoundException
     */
    @Override
    public ProductDto findProduct(int productId) throws ProductNotFoundException{
        try {
            return new ProductDto(productRepository
                     .findById(productId)
                    .get());
        }
        catch(Exception e){
            throw new ProductNotFoundException();
        }
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
