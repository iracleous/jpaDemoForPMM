package gr.codehub.jpademo.service;


import gr.codehub.jpademo.dto.OrderDto;
import gr.codehub.jpademo.dto.ProductDto;
import gr.codehub.jpademo.dto.ResultApi;
import gr.codehub.jpademo.exception.CustomerNotFoundException;
import gr.codehub.jpademo.exception.ProductNotFoundException;
import gr.codehub.jpademo.model.Customer;
import gr.codehub.jpademo.model.Order;
import gr.codehub.jpademo.model.Product;
import gr.codehub.jpademo.repository.CustomerRepository;
import gr.codehub.jpademo.repository.OrderRepository;
import gr.codehub.jpademo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    @Override
    public ResultApi<ProductDto> findProductAsResult(long productId) {
        Optional<Product> productOpt = productRepository.findById(productId);

        return productOpt.isPresent() ? new ResultApi<ProductDto>(new ProductDto(productOpt.get()), 0, "") : new ResultApi<ProductDto>(null, -1, "Product not found");

//         if(productOpt.isPresent()) {
//             return new ResultApi<ProductDto>(
//                     new ProductDto(productOpt.get()) , 0, "");
//         }
//         else
//             return new ResultApi<ProductDto>(null, -1,"Product not found");
    }

    @Override
    @Transactional
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
    public ProductDto findProduct(long productId) throws ProductNotFoundException {
        try {
            return new ProductDto(productRepository.findById(productId).get());
        } catch (Exception e) {
            throw new ProductNotFoundException();
        }
    }

    @Override
    public List<ProductDto> findProducts(Integer pageCount, Integer pageSize) {
        if (pageSize == null) pageSize = 10;
        if (pageCount == null) pageCount = 0;

        if (pageSize <= 0 || pageSize >= 50) pageSize = 10;
        if (pageCount < 0) pageCount = 0;
        Pageable page = PageRequest.of(pageCount, pageSize);

        return productRepository.findAll(page).stream().map(ProductDto::new).collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(long productId, ProductDto product) {
        return null;
    }

    @Override
    public boolean deleteProduct(long productId) {
        return false;
    }

    @Override
    public List<Double> findPrices() {
        return productRepository.findPrices();
    }

    @Override
    public List<ProductDto> findProductByNameAndByPrice(BigDecimal maximumPrice, String productName) {
        if (maximumPrice == null) maximumPrice = new BigDecimal(100);


        return productRepository.findProductByNameAndByPrice(maximumPrice, productName).stream().map(ProductDto::new).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public OrderDto createOrder(long customerId1, long customerId2) throws CustomerNotFoundException {
        Optional<Customer> customerOpt1 = customerRepository.findById(customerId1);
        if (customerOpt1.isEmpty()) {
            throw new CustomerNotFoundException();
        }
        Optional<Customer> customerOpt2 = customerRepository.findById(customerId2);
        if (customerOpt2.isEmpty()) {
            throw new CustomerNotFoundException();
        }
        Order order = new Order();
        order.setDate(LocalDateTime.now());
        order.setCustomer(customerOpt1.get());
        order.setSecondCustomer(customerOpt2.get());
        orderRepository.save(order);

        return new OrderDto(order);
    }
}
