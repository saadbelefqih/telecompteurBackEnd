package ma.ac.ensias.service;

import java.util.List;

import ma.ac.ensias.model.Compteur;

public interface ICompteurService {
	
	public Compteur addCompteur(Compteur customer);
	
	public List<Compteur> getAllCompteurs();
	
	public Compteur getCompteurById(Long id);
	
	public List<Compteur> getCompteursBySubscriptionCode(String subscriptionCode);
	
	public List<Compteur> getCompteursByMarque(String marque);
	
	public List<Compteur> getCompteursByCustomerID(Long idCustomer);
	
	public List<Compteur> getCompteursByCustomerCine(String cine);
	
	public List<Compteur> getCompteursByCustomerLname(String lname);
	
	public List<Compteur> getCompteursByCustomerFname(String fname);
			
	public Compteur updateCompteur(Compteur customer);
	
	public void deleleCompteur(Long id);

}
