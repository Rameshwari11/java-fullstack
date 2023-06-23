package com.cgi.service;

import java.util.List;
import java.util.Optional;

import com.cgi.model.Coupon;

public interface CouponService {

	public Coupon createCoupon(Coupon coupon);
	
	public List<Coupon>  getAllCoupons();
	
	public Optional<Coupon> getCouponByCode(int id);
	
}
