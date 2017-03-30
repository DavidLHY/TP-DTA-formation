package fr.pizzeria.dao.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("fr.pizzeria.dao")
@EnableTransactionManagement
@EnableJpaRepositories("fr.pizzeria.dao.repos")
public class DaoSpringConfig {

	@Bean
	@Qualifier("BaseProd")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/pizzeria");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}
	
	@Bean
	@Qualifier("BaseTest")
	public DataSource dataSourceH2() {
		

		return  new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
		.addScript("test-schema.sql")
		.build();
	}
	
	
	@Bean
	public PlatformTransactionManager txManager(){
		
		return new JpaTransactionManager();
		 
	}
	
	@Bean
	@Qualifier("lemfb")
	public LocalEntityManagerFactoryBean lemfb(){
		
		LocalEntityManagerFactoryBean localemf=new LocalEntityManagerFactoryBean();		
		localemf.setPersistenceUnitName("david-pizzeria-modelH2");
		
		return localemf;
	}
	

	@Bean	
	public EntityManagerFactory emf(){
		
		
		return lemfb().getNativeEntityManagerFactory();
	}
	

}
