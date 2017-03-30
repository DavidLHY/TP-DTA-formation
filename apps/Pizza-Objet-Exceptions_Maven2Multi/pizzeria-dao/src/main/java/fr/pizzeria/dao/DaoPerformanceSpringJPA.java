package fr.pizzeria.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.pizzeria.dao.repos.IPerfRepository;
import fr.pizzeria.modele.Performance;



public class DaoPerformanceSpringJPA implements Dao<Performance,String>{

	@Autowired private IPerfRepository perfRepository;
	
	
	@Override
	public List<Performance> findAll()
	{
	 return perfRepository.findAll();
	}
	
	@Override
	public boolean save(Performance e) {
		
		perfRepository.save(e);
		
		return false;
	}

	@Override
	public boolean update(String t, Performance e) {
		
		
Performance pmodi = perfRepository.getOne(t);
		
		e.setId(pmodi.getId());		
		perfRepository.save(e);
		
		return false;
	}

	@Override
	public boolean delete(String t) {
		
		perfRepository.delete(t);
		
		return false;
	}

}
