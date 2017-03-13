package fr.pizzeria.modele;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="commande")
public class Commande {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="numero_commande")
	private Integer numero_commande;	
	
	
	@Column(name="date_commande")
	private Date dat_commande;
	
	
	
	@Column(name="client_id")
	private Integer client_id;
	
	@ManyToOne
	@JoinColumn(name="livreur_id")
	private Livreur livreur;
	
	
	@ManyToMany
	@JoinTable(name="commande_pizza",
	  joinColumns=
	    @JoinColumn
	    (name="commande_id", referencedColumnName="id"),
	  inverseJoinColumns=
	    @JoinColumn(name="pizza_id", referencedColumnName="id")
	)
	private Set<Pizza> pizzas;
	

}
