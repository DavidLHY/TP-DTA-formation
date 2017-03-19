package fr.pizzeria.modele;

import java.util.Date;
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


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getNumero_commande() {
		return numero_commande;
	}


	public void setNumero_commande(Integer numero_commande) {
		this.numero_commande = numero_commande;
	}


	public Date getDat_commande() {
		return dat_commande;
	}


	public void setDat_commande(Date dat_commande) {
		this.dat_commande = dat_commande;
	}


	public Integer getClient_id() {
		return client_id;
	}


	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}


	public Livreur getLivreur() {
		return livreur;
	}


	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}


	public  Set<Pizza> getPizzas() {
		return pizzas;
	}


	public void setPizzas(Set<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	
}
