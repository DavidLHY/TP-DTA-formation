package fr.pizzeria.modele;

import java.lang.reflect.Field;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Pizza {

	@ToString
	private int id;
	@ToString(uppercase = true)
	private String code;
	@ToString(uppercase = true)
	private String nom;
	private double prix;
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
