package com.devmarco.dsmeta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmarco.dsmeta.domain.Seller;
import com.devmarco.dsmeta.requests.SellerPostRequestBody;
import com.devmarco.dsmeta.requests.SellerPutRequestBody;
import com.devmarco.dsmeta.service.SellerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/seller")
@RequiredArgsConstructor
public class SellerController {
	@Autowired
	private SellerService sellerService;
	
	
	@GetMapping
	public ResponseEntity<List<Seller>> list(){
		return ResponseEntity.ok(sellerService.findSeller());
	}
	
	@PostMapping
	public ResponseEntity<Seller> save(@RequestBody SellerPostRequestBody sellerPostRequestBody){
		return new ResponseEntity<>(sellerService.save(sellerPostRequestBody), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		sellerService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping
	public ResponseEntity<Void> replace(@RequestBody SellerPutRequestBody sellerPutRequestBody){
		sellerService.replace(sellerPutRequestBody);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
