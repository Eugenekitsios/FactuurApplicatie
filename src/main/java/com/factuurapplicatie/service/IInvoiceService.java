package com.factuurapplicatie.service;

import java.util.List;
import java.util.Optional;

import com.factuurapplicatie.model.Invoice;


public interface IInvoiceService {
	
public List<Invoice> findAll(); 
	
	//public List<Product> findbyCategory(String categoryName); 
	
	public Optional<Invoice> findInvoice(Long id);

	public Invoice create(Invoice invoice);
	
	public Invoice update(Invoice invoice);
	
	void delete(Invoice invoice);

	public Iterable<Invoice> findInvoiceByUserId(Long userId);

}
