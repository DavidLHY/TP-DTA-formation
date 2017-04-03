package dta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("fr.pizzeria")
@EnableJpaRepositories("fr.pizzeria.dao.repos")
public class PizzeriaStockAppSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzeriaStockAppSpringBootApplication.class, args);
	}
}
