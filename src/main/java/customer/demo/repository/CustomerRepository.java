package customer.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import customer.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>
{

}
