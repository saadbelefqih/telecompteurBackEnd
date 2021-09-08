package ma.ac.ensias.service;

import java.util.List;

import ma.ac.ensias.model.Compteur;

public interface ICompteurService {
	
	public Compteur addCompteur(Compteur customer);
	
	public List<Compteur> getAllCompteurs();
	
	public Compteur getCompteurById(Long id);
			
	public Compteur updateCompteur(Compteur customer);
	
	public void deleleCompteur(Long id);

}
