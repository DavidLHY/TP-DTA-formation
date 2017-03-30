package fr.pizzeria.modele;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="livreur")
public class Performance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	
	private String service;
	private LocalDateTime date;
	private long tempsExecution;
	
	
	
	
	
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public long getTempsExecution() {
		return tempsExecution;
	}
	public void setTempsExecution(long tempsExecution) {
		this.tempsExecution = tempsExecution;
	}
	
	
	

}
