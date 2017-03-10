package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.DaoException;


public interface Dao<E, T> {

	List<E> findAllPizzas();

	boolean save(E pizza) ;

	boolean update(T codePizza, E pizza) ;

	boolean delete(T codePizza) ;

	default void importData(Dao<E,T> source) {
		throw new DaoException("Non implémenté");
	}


}
