package gr.codehub.jpademo.repository;

import gr.codehub.jpademo.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

   List<Product> findByPriceLessThan(BigDecimal limit);
    Optional<Product> findFirstByName(String name);
      List<Product> findAllByName(Pageable page, String name);

    @Query("select distinct p.price from Product p")
    List<Double> findPrices();

    @Query("FROM Product p WHERE p.price <= :price and p.name = :name")
    List<Product> findProductByNameAndByPrice(@Param("price") BigDecimal productPriceUpperLimit,
                                         @Param("name") String productName);


}
