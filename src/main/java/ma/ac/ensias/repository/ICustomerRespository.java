package ma.ac.ensias.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.ensias.model.Customer;

public interface ICustomerRespository extends JpaRepository<Customer, Long>{

	void deleteCustomerByIdCustomer(Long idCustomer);
	
	 Optional<Customer> findCustomerByIdCustomer(Long idCustomer);
}
