package fr.pizzeria.dao.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.modele.Ingredient;


public interface IngredientRepository extends JpaRepository<Ingredient, String> {
	
	
	@Modifying
    @Transactional
    @Query("delete from Ingredient ingr where ingr.id = ?1")
    void deleteById(Integer id);
	
	
    Ingredient findById(Integer id);
	
	default void updateById(Integer id, Ingredient ingredient) {
		deleteById(id);
		save(ingredient);
	}
	
	
}
