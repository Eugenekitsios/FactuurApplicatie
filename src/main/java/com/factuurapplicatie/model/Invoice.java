package com.factuurapplicatie.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.time.LocalDate;

@Entity
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id; 
	private LocalDate date;
	private Double btw; 
	private Double nettoAmount;
	private Double brutoAmount; 
	private Double expenses;
	
	@ManyToOne (cascade = {CascadeType.ALL})
	@NotFound(
	        action = NotFoundAction.IGNORE)
	private InvoiceClient client;
	
	@ManyToOne
	@NotFound(
	        action = NotFoundAction.IGNORE)
	private User user;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Double getBtw() {
		return btw;
	}
	public void setBtw(Double btw) {
		this.btw = btw;
	}
	public Double getNettoAmount() {
		return nettoAmount;
	}
	public void setNettoAmount(Double nettoAmount) {
		this.nettoAmount = nettoAmount;
	}
	public Double getBrutoAmount() {
		return brutoAmount;
	}
	public void setBrutoAmount(Double brutoAmount) {
		this.brutoAmount = brutoAmount;
	}
	public Double getExpenses() {
		return expenses;
	}
	public void setExpenses(Double expenses) {
		this.expenses = expenses;
	}
	public InvoiceClient getClient() {
		return client;
	}
	public void setClient(InvoiceClient client) {
		this.client = client;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	} 
	
		
}
