package fr.pizzeria.dao.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.modele.Ingredient;


public interface IngredientRepository extends JpaRepository<Ingredient, String> {
	
	
	
}
