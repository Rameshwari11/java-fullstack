package com.cgi.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Coupon {

	private Long id;
	private String code;
	private BigDecimal discount;
	private String expDate;
}
