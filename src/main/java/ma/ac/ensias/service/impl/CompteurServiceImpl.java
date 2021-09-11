package ma.ac.ensias.service.impl;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.ac.ensias.exception.EntityNotFoundException;
import ma.ac.ensias.model.Compteur;
import ma.ac.ensias.repository.ICompteurRespository;
import ma.ac.ensias.service.ICompteurService;

@Service
@RequiredArgsConstructor
public class CompteurServiceImpl implements ICompteurService{
	
	private final ICompteurRespository compteurRespository;

	@Override
	public Compteur addCompteur(Compteur compteur) {
		compteur.setIdCompteur(null);
		compteur.setSubscriptioncode("C"+UUID.randomUUID().toString());
		Random r = new Random();
		
		double oldValue = 0 + (compteur.getMaxIndex() - 0) * r.nextDouble();
		double newValue = oldValue + (compteur.getNewIndex() - oldValue) * r.nextDouble();
		
		compteur.setOldIndex(oldValue);
		compteur.setNewIndex(newValue);
		
		return compteurRespository.save(compteur);
	}

	@Override
	public List<Compteur> getAllCompteurs() {
		return compteurRespository.findAll();
	}

	@Override
	public Compteur updateCompteur(Compteur compteur) {
		return compteurRespository.save(compteur);
	}

	@Override
	public void deleleCompteur(Long id) {
		compteurRespository.deleteCompteurByIdCompteur(id);
		
	}

	@Override
	public Compteur getCompteurById(Long id) {
		return compteurRespository.findCompteurByIdCompteur(id)
				.orElseThrow(()-> new EntityNotFoundException("Aucun client tourvé avec id :"+id));
	}

	@Override
	public List<Compteur> getCompteursByCustomerID(Long idCustomer) {
		return compteurRespository.findByCustomerById(idCustomer)
				.orElseThrow(()-> new EntityNotFoundException("Aucun client tourvé avec customer id :"+idCustomer));
	}

	@Override
	public List<Compteur> getCompteursBySubscriptionCode(String subscriptionCode) {
		return compteurRespository.findBySubscriptioncodeContainingIgnoreCase(null)
				.orElseThrow(()-> new EntityNotFoundException("Aucun client tourvé avec  :"+subscriptionCode));
	}

	@Override
	public List<Compteur> getCompteursByCustomerCine(String cine) {
		return compteurRespository.findByCustomerCine(cine)
				.orElseThrow(()-> new EntityNotFoundException("Aucun client tourvé avec  cine :"+cine));
	}

	@Override
	public List<Compteur> getCompteursByCustomerLname(String lname) {
		return compteurRespository.findByCustomerLname(lname)
				.orElseThrow(()-> new EntityNotFoundException("Aucun client tourvé avec  last name :"+lname));
	}

	@Override
	public List<Compteur> getCompteursByCustomerFname(String fname) {
		return compteurRespository.findByCustomerFname(fname)
				.orElseThrow(()-> new EntityNotFoundException("Aucun client tourvé avec  first name :"+fname));
	}
	
	@Override
	public List<Compteur> getCompteursByMarque(String marque) {
		return compteurRespository.findByMarqueContainingIgnoreCase(marque)
				.orElseThrow(()-> new EntityNotFoundException("Aucun client tourvé avec  first marque :"+marque));
	}

	
	

}
