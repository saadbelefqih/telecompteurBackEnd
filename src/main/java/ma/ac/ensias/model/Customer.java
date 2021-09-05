package ma.ac.ensias.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class Customer  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false,updatable = false)
	private Long idCustomer;
	private String fname;
	private String lname;
	@Column(nullable = false,unique = true)
	private String cine;
	private String email;
	private String account_fb;
	private String account_insta;
	private String account_twitter;
	private String phone;
	private String jobtitle;
	private String address;
	@Column(nullable = false,updatable = false)
	private String subscriptionCode;
	private String imageUrl;
	

}
