package fr.pizzeria.admin.web.event;

import java.time.LocalDateTime;

import fr.pizzeria.modele.Pizza;

public class SavePizzaEvent {
	
	
	private LocalDateTime localTime;	
	private Pizza pizza;

	public LocalDateTime getLocalTime() {
		return localTime;
	}

	public void setLocalTime(LocalDateTime localTime) {
		this.localTime = localTime;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	

	

}
