package com.factuurapplicatie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.factuurapplicatie.model.Invoice;


public interface IInvoiceDao extends CrudRepository<Invoice, Long > {
	
	@Override
	public List<Invoice> findAll();

	
	@Query
	(value = "SELECT * FROM Invoice WHERE user_id = :userId", nativeQuery = true)
	public Iterable<Invoice> findInvoiceByUserId(@Param("userId") Long userId); 
	

}
