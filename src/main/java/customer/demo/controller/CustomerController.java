package customer.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import customer.demo.entity.Customer;
import customer.demo.exception.CustomerNotFoundException;
import customer.demo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController 
{
	@Autowired
	CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping("/customers")
	public List<Customer> findAll()
	{
		return customerService.findAll();
	}
	
	@GetMapping("/customers/{customerId}") //http://localhost:8080/api/customers/4(id)
	public Customer findById(@PathVariable int customerId) throws CustomerNotFoundException 
	{
		Customer customer = customerService.findById(customerId);
		return customer;
	}
	
	@PostMapping("/customers") //insert
	public Customer addCustomer(@RequestBody Customer customer) //RequestBody - gets JSON object and stores in Customer Object(customer)
	{
		customer.setCustomerId(0); //to force insert instead of update
		customerService.save(customer);
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) //RequestBody - gets JSON object and stores in Customer Object(customer)
	{
		customerService.save(customer);
		return customer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) throws CustomerNotFoundException
	{
		customerService.deleteById(customerId);
		return "Deleted Customer Id = "+customerId;
	}
}
