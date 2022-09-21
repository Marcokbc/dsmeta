package com.devmarco.dsmeta.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmarco.dsmeta.domain.Seller;
import com.devmarco.dsmeta.exception.BadRequestException;
import com.devmarco.dsmeta.repository.SellerRepository;
import com.devmarco.dsmeta.requests.SellerPostRequestBody;
import com.devmarco.dsmeta.requests.SellerPutRequestBody;

@Service
public class SellerService {
	@Autowired
	private SellerRepository sellerRepository;
	
	public Seller findSeller(long id) {
		return sellerRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Seller Not Found"));
	}
	
	public List<Seller> findSeller(){
		return sellerRepository.findAll();
	}
	
	@Transactional
	public Seller save(SellerPostRequestBody sellerPostRequestBody) {
		return sellerRepository.save(Seller.builder()
						.name(sellerPostRequestBody.getName())
						.build()
				);
	}
	
	public void delete(long id) {
		sellerRepository.delete(findSeller(id));
	}
	
	public void replace(SellerPutRequestBody sellerPutRequestBody) {
		Seller savedSeller = findSeller(sellerPutRequestBody.getId());
		Seller seller = Seller.builder()
				.id(savedSeller.getId())
				.name(sellerPutRequestBody.getName())
				.build();
		
		sellerRepository.save(seller);
	}
}
