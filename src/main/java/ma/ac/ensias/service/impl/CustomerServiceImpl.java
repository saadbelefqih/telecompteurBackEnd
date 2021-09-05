package ma.ac.ensias.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.ac.ensias.exception.EntityNotFoundException;
import ma.ac.ensias.model.Customer;
import ma.ac.ensias.repository.ICustomerRespository;
import ma.ac.ensias.service.ICustomerService;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService{
	
	private final ICustomerRespository customerRespository;

	@Override
	public Customer addCustomer(Customer customer) {
		customer.setSubscriptionCode(UUID.randomUUID().toString());
		return customerRespository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRespository.findAll();
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRespository.save(customer);
	}

	@Override
	public void deleleCustomer(Long id) {
		customerRespository.deleteCustomerByIdCustomer(id);
		
	}

	@Override
	public Customer getCustomerById(Long id) {
		return customerRespository.findCustomerByIdCustomer(id)
				.orElseThrow(()-> new EntityNotFoundException("Aucun client tourvé avec id :"+id));
	}

	@Override
	public List<Customer> getCustomersByFname(String fname) {
		return customerRespository.findByFnameContainingIgnoreCase(fname).orElseThrow(()-> new EntityNotFoundException("Aucun client tourvé avec :"+fname));
	}

	@Override
	public List<Customer> getCustomersByLname(String lname) {
		return customerRespository.findByLnameContainingIgnoreCase(lname).orElseThrow(()-> new EntityNotFoundException("Aucun client tourvé avec :"+lname));
	}

	@Override
	public List<Customer> getCustomersByCine(String cine) {
		return customerRespository.findByCineContainingIgnoreCase(cine).orElseThrow(()-> new EntityNotFoundException("Aucun client tourvé avec :"+cine));
	}

	@Override
	public List<Customer> getCustomersByJobTitle(String job) {
		return customerRespository.findByJobtitleContainingIgnoreCase(job).orElseThrow(()-> new EntityNotFoundException("Aucun client tourvé avec :"+job));
	}
	
	

}
