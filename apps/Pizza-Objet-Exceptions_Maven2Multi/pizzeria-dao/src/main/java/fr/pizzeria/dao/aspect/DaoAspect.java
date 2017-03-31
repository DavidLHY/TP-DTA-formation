package fr.pizzeria.dao.aspect;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.repos.IPerfRepository;
import fr.pizzeria.modele.Performance;
import fr.pizzeria.modele.Pizza;

@Aspect
@Component
public class DaoAspect {
	

	@Autowired private IPerfRepository perfJPA;
	
	
	@Before("execution(* fr.pizzeria.dao.Dao.save(..)) && args(pizza)")
	private void codeVidePizza(JoinPoint jps,Pizza pizza)
	{
		if(pizza.getCode().equals("") )
		{
			pizza.setCode("P"+pizza.getNom().substring(0,3).toUpperCase());
		}
		
	}
	
	@Around("execution(* fr.pizzeria.dao.Dao.*(..))")
	private Object TestPerf(ProceedingJoinPoint jps) throws Throwable
	{
		
		
		
		long t1= System.currentTimeMillis( );
		
		Object resultat = jps.proceed();
		
		long t2= System.currentTimeMillis( ) - t1  ;
		
		System.out.println(t2 + " [ms]");
		
		Performance pr = new Performance();
		
		pr.setDate(LocalDateTime.now());
		pr.setService(jps.getKind());
		pr.setTempsExecution(t2);
		
		perfJPA.save(pr);
		return resultat;
		
	}
	
	
	
	
}
