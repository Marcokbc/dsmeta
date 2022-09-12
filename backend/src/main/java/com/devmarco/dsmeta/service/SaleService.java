package com.devmarco.dsmeta.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devmarco.dsmeta.repository.SaleRepository;
import com.devmarco.dsmeta.requests.SalePostRequestBody;
import com.devmarco.dsmeta.requests.SalePutRequestBody;
import com.devmarco.dsmeta.domain.Sale;
import com.devmarco.dsmeta.exception.BadRequestException;



@Service
public class SaleService {
	@Autowired
	private SaleRepository saleRepository;
	
	public Sale findSale(long id) {
		return saleRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Sale Not Found"));
	}
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable){
		LocalDate today = LocalDate.ofInstant(
				Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = minDate.equals("") ? 
				today.minusDays(365): LocalDate.parse(minDate);
		
		LocalDate max = maxDate.equals("")? today : LocalDate.parse(maxDate);
		return saleRepository.findSales(min, max, pageable);
	}
	
	@Transactional
	public Sale save(SalePostRequestBody salePostRequestBody) {
		return saleRepository.save(Sale.builder()
						.sellerName(salePostRequestBody.getSellerName())
						.visited(salePostRequestBody.getVisited())
						.deals(salePostRequestBody.getDeals())
						.amount(salePostRequestBody.getAmount())
						.date(salePostRequestBody.getDate())
						.build()
				);
	}
	
	public void delete(long id) {
		saleRepository.delete(findSale(id));
	}
	
	public void replace(SalePutRequestBody salePutRequestBody) {
		Sale savedSale = findSale(salePutRequestBody.getId());
		Sale sale = Sale.builder()
				.id(savedSale.getId())
				.sellerName(salePutRequestBody.getSellerName())
				.visited(salePutRequestBody.getVisited())
				.deals(salePutRequestBody.getDeals())
				.amount(salePutRequestBody.getAmount())
				.date(salePutRequestBody.getDate())
				.build();
		
		saleRepository.save(sale);
	}
}
