package co.pragra.pragracofeetime.repo;

import co.pragra.pragracofeetime.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT c from Customer c where upper(c.lastName) = upper( :lastName )")
    List<Customer> findAllByLastName(@Param("lastName") String lastName);
}
