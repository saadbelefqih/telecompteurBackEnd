package ma.ac.ensias.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import ma.ac.ensias.model.Compteur;
import ma.ac.ensias.service.ICompteurService;
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/compteur")
public class CompteurController {
	
	private final ICompteurService compteurService;
	
	
	  	@GetMapping("/all")
	    public ResponseEntity<List<Compteur>> getAllCompteurs () {
	        List<Compteur> compteurs = compteurService.getAllCompteurs();
	        return new ResponseEntity<>(compteurs, HttpStatus.OK);
	    }
	  
	    @GetMapping("/find/{id}")
	    public ResponseEntity<Compteur> getCompteurById (@PathVariable("id") Long id) {
	    	Compteur compteur = compteurService.getCompteurById(id);
	        return new ResponseEntity<>(compteur, HttpStatus.OK);
	    }
	    
	    @GetMapping("/find/customer/{id}")
	    public ResponseEntity<List<Compteur>> getCompteurByCustomer (@PathVariable("id") Long idCustomer) {
	    	List<Compteur> compteurs = compteurService.getCompteursByCustomerID(idCustomer);
	        return new ResponseEntity<>(compteurs, HttpStatus.OK);
	    }
	    
	    
	    @GetMapping("/find/customer/cine/{c}")
	    public ResponseEntity<List<Compteur>> getCompteurByCustomerCine (@PathVariable("c") String cine) {
	    	List<Compteur> compteurs = compteurService.getCompteursByCustomerCine(cine);
	        return new ResponseEntity<>(compteurs, HttpStatus.OK);
	    }
	    
	    @GetMapping("/find/customer/lname/{p}")
	    public ResponseEntity<List<Compteur>> getCompteurByCustomerLname (@PathVariable("p") String p) {
	    	List<Compteur> compteurs = compteurService.getCompteursByCustomerLname(p);
	        return new ResponseEntity<>(compteurs, HttpStatus.OK);
	    }
	    
	    @GetMapping("/find/customer/fname/{p}")
	    public ResponseEntity<List<Compteur>> getCompteurByCustomerFname (@PathVariable("p") String p) {
	    	List<Compteur> compteurs = compteurService.getCompteursByCustomerFname(p);
	        return new ResponseEntity<>(compteurs, HttpStatus.OK);
	    }
	    
	    @GetMapping("/find/subscription/{p}")
	    public ResponseEntity<List<Compteur>> getCompteurByCustomerSubscription (@PathVariable("p") String p) {
	    	List<Compteur> compteurs = compteurService.getCompteursBySubscriptionCode(p);
	        return new ResponseEntity<>(compteurs, HttpStatus.OK);
	    }
	    
	    @GetMapping("/find/marque/{p}")
	    public ResponseEntity<List<Compteur>> getCompteurByCustomerMarque (@PathVariable("p") String p) {
	    	List<Compteur> compteurs = compteurService.getCompteursByMarque(p);
	        return new ResponseEntity<>(compteurs, HttpStatus.OK);
	    }
	    	  		    
	    @PostMapping("/add")
	    public ResponseEntity<Compteur> addCompteur(@RequestBody Compteur compteur) {
	    	Compteur newCompteur = compteurService.addCompteur(compteur);
	        return new ResponseEntity<>(newCompteur, HttpStatus.CREATED);
	    }

	    @PutMapping("/update")
	    public ResponseEntity<Compteur> updateCompteur(@RequestBody Compteur compteur) {
	    	Compteur updateCompteur = compteurService.updateCompteur(compteur);
	        return new ResponseEntity<>(updateCompteur, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteCompteur(@PathVariable("id") Long id) {
	    	compteurService.deleleCompteur(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	    
	    @PostMapping(path="/uploadPhoto/{id}")
		public void uploadPhoto(MultipartFile file , @PathVariable("id") Long id) throws Exception
		{
			Compteur compteur = compteurService.getCompteurById(id);
			
			if(compteur != null)
			{
			compteur.setPhotoName(file.getOriginalFilename());
			
			
			Files.write(Paths.get(System.getProperty("user.home")+"/telecompteurs/"+compteur.getPhotoName()),file.getBytes());
			compteurService.updateCompteur(compteur);
			}
		}
	    
	    @GetMapping(path="/getPhoto/{id}", produces=org.springframework.http.MediaType.IMAGE_PNG_VALUE)
		public byte[] getPhoto(@PathVariable("id") Long id) throws IOException
	    {
	    	Compteur compteur=  compteurService.getCompteurById(id);
			return Files.readAllBytes(Paths.get((System.getProperty("user.home")+"/telecompteurs/"+compteur.getPhotoName())));
	    }

}
