package com.devmarco.dsmeta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devmarco.dsmeta.domain.Sale;
import com.devmarco.dsmeta.requests.SalePostRequestBody;
import com.devmarco.dsmeta.requests.SalePutRequestBody;
import com.devmarco.dsmeta.service.SaleService;
import com.devmarco.dsmeta.service.SmsService;



import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/sales")
@RequiredArgsConstructor
public class SaleController {
	@Autowired
	private SaleService saleService;
	
	@Autowired
	private SmsService smsService;
	
	@GetMapping
	public ResponseEntity<Page<Sale>> findSales(
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate,
			Pageable pageable){
		return ResponseEntity.ok(
				saleService.findSales(minDate, maxDate, pageable));
	}
	
	@GetMapping("/{id}/notification")
	public void notifySmsO(@PathVariable Long id) {
		smsService.sendSms(id);
	}
	
	@PostMapping
	public ResponseEntity<Sale> save(@RequestBody SalePostRequestBody salePostRequestBody){
		return new ResponseEntity<>(saleService.save(salePostRequestBody), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		saleService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping
	public ResponseEntity<Void> replace(@RequestBody SalePutRequestBody salePutRequestBody){
		saleService.replace(salePutRequestBody);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
