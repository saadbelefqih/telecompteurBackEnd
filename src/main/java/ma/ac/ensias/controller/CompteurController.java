package ma.ac.ensias.controller;


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

import lombok.RequiredArgsConstructor;
import ma.ac.ensias.model.Customer;
import ma.ac.ensias.service.ICustomerService;
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CompteurController {
	
	private final ICustomerService customerService;
	
	  	@GetMapping("/all")
	    public ResponseEntity<List<Customer>> getAllCustomers () {
	        List<Customer> customers = customerService.getAllCustomers();
	        return new ResponseEntity<>(customers, HttpStatus.OK);
	    }
	  
	    @GetMapping("/find/id/{id}")
	    public ResponseEntity<Customer> getCustomerById (@PathVariable("id") Long id) {
	    	Customer customer = customerService.getCustomerById(id);
	        return new ResponseEntity<>(customer, HttpStatus.OK);
	    }
	    
	  	@GetMapping("/find/cine/{p}")
	    public ResponseEntity<List<Customer>> getCustomersByCine (@PathVariable("p") String p) {
	        List<Customer> customers = customerService.getCustomersByCine(p);
	        return new ResponseEntity<>(customers, HttpStatus.OK);
	    }
	  	
	  	@GetMapping("/find/fname/{p}")
	    public ResponseEntity<List<Customer>> getCustomersByFname (@PathVariable("p") String p) {
	        List<Customer> customers = customerService.getCustomersByFname(p);
	        return new ResponseEntity<>(customers, HttpStatus.OK);
	    }
	  	
	  	@GetMapping("/find/lname/{p}")
	    public ResponseEntity<List<Customer>> getCustomersByLname (@PathVariable("p") String p) {
	        List<Customer> customers = customerService.getCustomersByLname(p);
	        return new ResponseEntity<>(customers, HttpStatus.OK);
	    }
	  	
	  	@GetMapping("/find/job/{p}")
	    public ResponseEntity<List<Customer>> getCustomersByJob (@PathVariable("p") String p) {
	        List<Customer> customers = customerService.getCustomersByJobTitle(p);
	        return new ResponseEntity<>(customers, HttpStatus.OK);
	    }
	    
	    @PostMapping("/add")
	    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
	    	Customer newCustomer = customerService.addCustomer(customer);
	        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
	    }

	    @PutMapping("/update")
	    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
	    	Customer updateCustomer = customerService.updateCustomer(customer);
	        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id) {
	    	customerService.deleleCustomer(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }

}
