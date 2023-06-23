package com.cgi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="coupon_table")
public class Coupon {
	
	@Id
	@Column(name="coupon_code")
	private int couponCode;
	
	@Column(name="discount")
	private int discount;

}
