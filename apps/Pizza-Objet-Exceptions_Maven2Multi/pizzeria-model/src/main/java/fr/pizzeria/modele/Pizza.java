package fr.pizzeria.modele;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@NamedQuery(name = "Pizza.findAll", query = "SELECT p FROM Pizza p")
public class Pizza {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="reference")
	private String code;
	
	@Column(name="libelle")
	private String nom;
	
	@Column(name="prix")
	private double prix;
	
	@Column(name="url_image")
	private String urlImage;
	
	@Enumerated(EnumType.STRING)
	@Column(name="categorie")
	private CategoriePizza categoriePizza;


	
	public Pizza( String code, String nom, double prix, CategoriePizza categoriePizza) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categoriePizza = categoriePizza;
		
	}

	public Pizza() {

		
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	@Override
	public String toString() {
		return "" + code + ", " + nom + ", " + prix + "," + categoriePizza ;
	}
	
	

}
