package fr.pizzeria.admin.web.event;

import java.time.LocalDateTime;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;

import fr.pizzeria.modele.Pizza;

public class EventAction {
	
	
	private LocalDateTime localTime;
	
	private Event<Pizza> pizzaEvent;
	
	public void savePizzaEvent(@Observes Pizza event) {

		localTime=LocalDateTime.now();
		System.out.println("Pizza Ajout");
		System.out.println(event +"  "+ localTime);

		}



	public void fire(Pizza pizza) {
		
		
		
	}
	

}
