package fr.pizzeria.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import fr.pizzeria.dao.PizzaDaoSpringReposJPA;
import fr.pizzeria.dao.aspect.DaoAspect;

@Configuration
@Import({DaoAspect.class, PizzaDaoSpringReposJPA.class})
@EnableTransactionManagement
@EnableJpaRepositories("fr.pizzeria.dao.repos")
@EnableAspectJAutoProxy
@EnableWebMvc
public class DaoSpringDataJPATestConfig {

	
	
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
