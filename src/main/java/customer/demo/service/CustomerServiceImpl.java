package customer.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customer.demo.entity.Customer;
import customer.demo.exception.CustomerNotFoundException;
import customer.demo.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService 
{
	CustomerRepository customerRepository;
	@Autowired //to inject object of customer repository
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAll() 
	{
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}

	@Override
	public void deleteById(int Id) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		Customer customer = findById(Id);
		if(customer == null)
		{
			throw new CustomerNotFoundException("Customer Id not found " + Id);
		}
		customerRepository.deleteById(Id);
	}

	@Override
	public Customer findById(int Id) throws CustomerNotFoundException
	{
		// TODO Auto-generated method stub
		Optional<Customer> result = customerRepository.findById(Id); //id=101, to handle null
		
		Customer theCustomer;
		
		if(result.isPresent()) {
			theCustomer = result.get();
		}
		else {
			throw new CustomerNotFoundException("did not find customer id : "+Id);
		}
		return theCustomer;
	}
	@Override
	public void updateById(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}

}





