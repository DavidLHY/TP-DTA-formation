package fr.pizzeria.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.pizzeria.dao.PizzaDaoSpringReposJPA;

@Configuration
@Import(PizzaDaoSpringReposJPA.class)
@EnableTransactionManagement
@EnableJpaRepositories("fr.pizzeria.dao.repos")
public class DaoSpringDataJPAConfig {

	
	
	@Bean
	public PlatformTransactionManager transactionManager(){
		return new JpaTransactionManager();
		 
	}
	
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory(){
		
		LocalEntityManagerFactoryBean localemf=new LocalEntityManagerFactoryBean();		
		localemf.setPersistenceUnitName("david-pizzeria-modelH2");
		
		return localemf;
	}
	
	

}
