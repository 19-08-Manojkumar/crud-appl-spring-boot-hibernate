package customer.demo.service;

import java.util.List;

import customer.demo.entity.Customer;
import customer.demo.exception.CustomerNotFoundException;

public interface CustomerService 
{
	public List<Customer> findAll();
	void save(Customer customer);
	void deleteById(int Id) throws CustomerNotFoundException;
	Customer findById(int Id) throws CustomerNotFoundException;
	void updateById(Customer customer);
	
}
