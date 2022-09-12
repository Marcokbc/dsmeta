package com.devmarco.dsmeta.requests;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SalePutRequestBody {
	private Long id;
	private String sellerName;
	private Integer visited;
	private Integer deals;
	private Double amount;
	private LocalDate date;
}