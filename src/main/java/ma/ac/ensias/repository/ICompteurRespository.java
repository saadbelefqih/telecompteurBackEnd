package ma.ac.ensias.repository;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.ac.ensias.model.Compteur;

public interface ICompteurRespository extends JpaRepository<Compteur, Long>{
	
	@Transactional
	void deleteCompteurByIdCompteur(Long idCompteur);
	
	 Optional<Compteur> findCompteurByIdCompteur(Long idCompteur);
	 
	 Optional<List<Compteur>> findByMarqueContainingIgnoreCase(String subscriptionCode);
	 
	 Optional<List<Compteur>> findBySubscriptioncodeContainingIgnoreCase(String subscriptionCode);
	 
	 @Query("SELECT compteur from Compteur as compteur where compteur.customer.idCustomer = :idCustomer")
	 Optional<List<Compteur>> findByCustomerById(Long idCustomer);
	 
	 @Query("SELECT compteur from Compteur as compteur where compteur.customer.fname LIKE %?1%")
	 Optional<List<Compteur>> findByCustomerFname(String fname);
	 
	 @Query("SELECT compteur from Compteur as compteur where compteur.customer.lname LIKE  %?1%")
	 Optional<List<Compteur>> findByCustomerLname(String lname);
	 
	 @Query("SELECT compteur from Compteur as compteur where compteur.customer.cine LIKE %?1%")
	 Optional<List<Compteur>> findByCustomerCine(String cine);
	 

	 
}
