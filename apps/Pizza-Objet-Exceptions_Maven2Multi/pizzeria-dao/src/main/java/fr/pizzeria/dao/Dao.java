package fr.pizzeria.dao;

import java.util.List;
import java.util.Set;

import fr.pizzeria.exception.DaoException;


public interface Dao<E, T> {

	default List<E> findAll()
	{
		throw new DaoException("Non implémenté");
	}

	boolean save(E e) ;

	boolean update(T t, E e) ;

	boolean delete(T t) ;

	default void importData(Dao<E,T> source) {
		throw new DaoException("Non implémenté");
	}
	
	default public Set<E> findby(T t1,Object t3){
		throw new DaoException("Non implementé");
	};

}
