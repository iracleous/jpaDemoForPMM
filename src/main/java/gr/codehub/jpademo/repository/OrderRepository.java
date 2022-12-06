package gr.codehub.jpademo.repository;

import gr.codehub.jpademo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
