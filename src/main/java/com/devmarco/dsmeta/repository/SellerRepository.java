package com.devmarco.dsmeta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmarco.dsmeta.domain.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{
}
