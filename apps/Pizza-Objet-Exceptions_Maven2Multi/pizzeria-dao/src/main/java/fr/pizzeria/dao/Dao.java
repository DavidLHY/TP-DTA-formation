package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.modele.Pizza;


public interface Dao<E, T> {

	List<E> findAllPizzas();

	boolean save(E pizza) ;

	boolean update(T codePizza, E pizza) ;

	boolean delete(T codePizza) ;

	
	
	

}
