package com.devmarco.dsmeta.requests;

import java.time.LocalDate;

import com.devmarco.dsmeta.domain.Seller;

import lombok.Data;

@Data
public class SalePostRequestBody {
	private Seller seller;
	private Integer visited;
	private Integer deals;
	private Double amount;
	private LocalDate date;
}
