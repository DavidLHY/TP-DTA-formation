package fr.pizzeria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import fr.pizzeria.dao.config.DaoSpringDataJPAConfig;

@Configuration
@Import({DaoSpringDataJPAConfig.class})
@EnableJpaRepositories("fr.pizzeria.dao.repos")
@ComponentScan("fr.pizzeria.controller")
@EnableWebMvc
public class StockConfig {
	
	
	@Bean
	public ViewResolver viewResolver(){
		
		InternalResourceViewResolver ivr = new InternalResourceViewResolver();
		ivr.setPrefix("/WEB-INF/views/");
		ivr.setSuffix(".jsp");
		
		return ivr;
		
	}
	
	

}
