package ma.ac.ensias.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.ensias.model.Customer;

public interface ICustomerRespository extends JpaRepository<Customer, Long>{
	
	@Transactional
	void deleteCustomerByIdCustomer(Long idCustomer);
	
	 Optional<Customer> findCustomerByIdCustomer(Long idCustomer);
	 
	 Optional<List<Customer>> findByCineContainingIgnoreCase(String cINE);
	 
	 Optional<List<Customer>> findByFnameContainingIgnoreCase(String fName);
	 
	 Optional<List<Customer>> findByLnameContainingIgnoreCase(String lName);
	 
	 Optional<List<Customer>> findByJobtitleContainingIgnoreCase(String jobTitle);
	 
	 
}
