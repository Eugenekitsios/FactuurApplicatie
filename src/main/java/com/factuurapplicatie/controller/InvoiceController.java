package com.factuurapplicatie.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.factuurapplicatie.DTO.InvoiceDto;
import com.factuurapplicatie.model.Invoice;
import com.factuurapplicatie.service.IInvoiceService;


@RestController
//@SpringBootApplication
public class InvoiceController {
	
	@Autowired
	private IInvoiceService iInvoiceService; 

	
	@PostMapping("/api/invoice")
	//@RequestMapping(value = "/api/invoice", method = RequestMethod.GET)
	public Invoice create(@RequestBody Invoice invoice) {
		return this.iInvoiceService.create(invoice);
	}
	
	@GetMapping("/api/invoice/{id}")
	public InvoiceDto findById(@PathVariable Long id) {
		
		Optional<Invoice> optional = this.iInvoiceService.findInvoice(id);

		if (optional.isPresent()) {
			InvoiceDto invoiceDto = new InvoiceDto(); 
			invoiceDto.setId(optional.get().getId());
			invoiceDto.setBrutoAmount(optional.get().getBrutoAmount());
			invoiceDto.setNettoAmount(optional.get().getNettoAmount());
			invoiceDto.setBtw(optional.get().getBtw());
			invoiceDto.setDate(optional.get().getDate());
			invoiceDto.setExpenses(optional.get().getExpenses());
			invoiceDto.setUser(optional.get().getUser());
			invoiceDto.setClient(optional.get().getClient());
		
			
			return invoiceDto;
		}
		return null;
	}
	
	@GetMapping("/api/invoice/all")
	public List<Invoice> findAll() {
		return this.iInvoiceService.findAll();
		
	}
}
