package com.devmarco.dsmeta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmarco.dsmeta.repository.SaleRepository;
import com.devmarco.dsmeta.domain.Sale;



@Service
public class SaleService {
	@Autowired
	private SaleRepository saleRepository;
	
	public List<Sale> findSales(){
		return saleRepository.findAll();
	}
}
