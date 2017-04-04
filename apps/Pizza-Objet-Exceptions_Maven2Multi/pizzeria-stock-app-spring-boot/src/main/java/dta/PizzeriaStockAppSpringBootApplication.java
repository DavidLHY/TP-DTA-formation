package dta;

import fr.pizzeria.dao.repos.IngredientRepository;
import fr.pizzeria.modele.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EntityScan("fr.pizzeria")
@EnableJpaRepositories("fr.pizzeria.dao.repos")
public class PizzeriaStockAppSpringBootApplication {

	@Autowired private IngredientRepository ingredientRepository;


	@PostConstruct
	public void initApp() {
		ingredientRepository.save(buildIngredient(1));
		ingredientRepository.save(buildIngredient(2));
		ingredientRepository.save(buildIngredient(3));
	}

	private Ingredient buildIngredient(Integer index) {
		Ingredient ingredient = new Ingredient();
		ingredient.setNom("A"+index);
		ingredient.setPrix(0.0+index);
		ingredient.setQuantite(index);
		return ingredient;
	}


	public static void main(String[] args) {
		SpringApplication.run(PizzeriaStockAppSpringBootApplication.class, args);
	}
}
