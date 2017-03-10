package fr.pizzeria.modele;


public enum CategoriePizza {
	
	VIANDE("Viande"),
	POISSON("Poisson"),
	SANS_VIANDE("Sans Viande");

	private String categorie = " ";

	private CategoriePizza(String categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return this.categorie;
	}
}
