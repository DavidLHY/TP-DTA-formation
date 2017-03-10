package fr.pizzeria.modele;



import javax.persistence.Entity;

import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Pizza {

	
	
	@Id
	@GeneratedValue
	private int id;
	
	
	private String code;
	
	private String nom;
	
	private double prix;
	
	@Enumerated
	private CategoriePizza categoriePizza;

	public Pizza(int id, String code, String nom, double prix, CategoriePizza categoriePizza) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categoriePizza = categoriePizza;
		;
	}

	public Pizza() {
		this.id = 0;
		this.code = " aa  ";
		this.nom = " ";
		this.prix = 0.0;
		
	}

	public void printPizza() {

		System.out.println(code + "\t" + nom + ((nom.length() < 8) ? ("\t") : " ") + "\t (" + prix + " €)"
				+ "\t Dans la categorie :" + categoriePizza.toString());

	}
	
	

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object pizza) {
		return EqualsBuilder.reflectionEquals(this, pizza);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public CategoriePizza getCategoriePizza() {
		return categoriePizza;
	}

	public void setCategoriePizza(CategoriePizza categoriePizza) {
		this.categoriePizza = categoriePizza;
	}

}
