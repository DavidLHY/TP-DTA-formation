package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.DaoException;

public interface Dao<E, T> {

	List<E> findAllPizzas();

	boolean save(E pizza) throws DaoException;;

	boolean update(T codePizza, E pizza) throws DaoException;;

	boolean delete(T codePizza) throws DaoException;;

}
