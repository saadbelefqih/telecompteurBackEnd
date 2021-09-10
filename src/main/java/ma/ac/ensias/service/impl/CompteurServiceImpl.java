package ma.ac.ensias.service.impl;

import java.util.List;
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
		compteur.setNumCompteur("C"+UUID.randomUUID().toString());
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

	
	

}
