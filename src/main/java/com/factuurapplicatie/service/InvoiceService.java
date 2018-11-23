package com.factuurapplicatie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.util.Assert;

import com.factuurapplicatie.dao.IInvoiceDao;
import com.factuurapplicatie.model.Invoice;


@Service
public class InvoiceService implements IInvoiceService {
	
	@Autowired
	private IInvoiceDao iInvoiceDao; 

	@Override
	public List<Invoice> findAll() {
		return this.iInvoiceDao.findAll(); 
	}

	@Override
	public Optional<Invoice> findInvoice(Long id) {
		if (id < 0)
			return Optional.empty();

		return this.iInvoiceDao.findById(id);
		
	}

	@Override
	public Invoice create(Invoice invoice) {
		//Assert.notNull(invoice, "Product may not be null");

		return this.iInvoiceDao.save(invoice);
	}

	@Override
	public Invoice update(Invoice invoice) {
		
		return this.iInvoiceDao.save(invoice);
	}

	@Override
	public void delete(Invoice invoice) {
		
		this.iInvoiceDao.delete(invoice);
		
	}

	@Override
	public Iterable<Invoice> findInvoiceByUserId(Long userId) {
		return this.iInvoiceDao.findInvoiceByUserId(userId);
	}

}
