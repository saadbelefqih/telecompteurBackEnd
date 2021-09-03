package ma.ac.ensias.service;

import java.util.List;

import ma.ac.ensias.model.Customer;

public interface ICustomerService {
	
	public Customer addCustomer(Customer customer);
	
	public List<Customer> getAllCustomers();
	
	public Customer getCustomerById(Long id);
	
	public Customer updateCustomer(Customer customer);
	
	public void deleleCustomer(Long id);

}
