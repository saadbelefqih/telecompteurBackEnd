package ma.ac.ensias.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Compteur  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false,updatable = false)
	private Long idCompteur;
	@Column(nullable = false,updatable = false)
	private String marque;
	@Column(nullable = false,updatable = false)
	private String subscriptioncode;
	@Column(precision=10, scale=2)
	private Double oldIndex;
	@Column(precision=10, scale=2)
	private Double newIndex;
	@Column(precision=10, scale=2)
	private Double maxIndex;
	private Date datePrelevement;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId",nullable = true)
	private Customer customer;
	private Float latitude;
	private Float longitude;
	private String photoName;

}
