package gr.codehub.jpademo.repository;

import gr.codehub.jpademo.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
