package fr.pizzeria.admin.metier;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import fr.pizzeria.admin.web.event.DeletePizzaEvent;
import fr.pizzeria.admin.web.event.SavePizzaEvent;
import fr.pizzeria.admin.web.event.UpdatePizzaEvent;


@ApplicationScoped
public class PizzaStatService {

	private List<SavePizzaEvent> savePizzas = new ArrayList<>();
	private List<UpdatePizzaEvent> updatePizzas = new ArrayList<>();
	private List<DeletePizzaEvent> deletePizzas = new ArrayList<>();

	public void ecouteCreer(@Observes SavePizzaEvent event) {		
		savePizzas.add(event);		
	}

	public void ecouteModifier(@Observes UpdatePizzaEvent event) {
		updatePizzas.add(event);
	}

	public void ecouteSupprimer(@Observes DeletePizzaEvent event) {
		deletePizzas.add(event);
	}

	public List<SavePizzaEvent> getSavePizzas() {
		return savePizzas;
	}

	public List<UpdatePizzaEvent> getUpdatePizzas() {
		return updatePizzas;
	}

	public List<DeletePizzaEvent> getDeletePizzas() {
		return deletePizzas;
	}

}