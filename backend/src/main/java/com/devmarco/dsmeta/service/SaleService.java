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
import com.devmarco.dsmeta.domain.Sale;



@Service
public class SaleService {
	@Autowired
	private SaleRepository saleRepository;
	
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
}
