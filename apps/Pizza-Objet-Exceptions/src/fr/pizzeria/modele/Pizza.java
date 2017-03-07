package fr.pizzeria.modele;

import java.lang.reflect.Field;

public class Pizza {

	@ToString
	private int id;
	@ToString(uppercase = true)
	private String code;
	@ToString(uppercase = true)
	private String nom;
	private double prix;
	private static int nbPizzas;
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
		nbPizzas++;
	}

	public void printPizza() {

		System.out.println(code + "\t" + nom + ((nom.length() < 8) ? ("\t") : " ") + "\t (" + prix + " �)"
				+ "\t Dans la categorie :" + categoriePizza.toString());

	}

	public String toString() {

		StringBuilder sb = new StringBuilder();

		for (Field champ : this.getClass().getDeclaredFields()) {
			ToString annotationTrouve = champ.getAnnotation(ToString.class);
			if (annotationTrouve != null) {
				try {
					sb.append(champ.get(this).toString());
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

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

	public static int getNbPizzas() {
		return nbPizzas;
	}

	public static void setNbpizzas(int nbpizzas) {
		Pizza.nbPizzas = nbpizzas;
	}

	public CategoriePizza getCategoriePizza() {
		return categoriePizza;
	}

	public void setCategoriePizza(CategoriePizza categoriePizza) {
		this.categoriePizza = categoriePizza;
	}

}
