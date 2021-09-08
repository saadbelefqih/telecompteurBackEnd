package ma.ac.ensias.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.ensias.model.Compteur;
import ma.ac.ensias.model.Compteur;

public interface ICompteurRespository extends JpaRepository<Compteur, Long>{
	
	@Transactional
	void deleteCompteurByIdCompteur(Long idCompteur);
	
	 Optional<Compteur> findCompteurByIdCompteur(Long idCompteur);
	 
//	 Optional<List<Compteur>> findByCineContainingIgnoreCase(String cINE);
//	 
//	 Optional<List<Compteur>> findByFnameContainingIgnoreCase(String fName);
//	 
//	 Optional<List<Compteur>> findByLnameContainingIgnoreCase(String lName);
//	 
//	 Optional<List<Compteur>> findByJobtitleContainingIgnoreCase(String jobTitle);
//	 
	 
}
