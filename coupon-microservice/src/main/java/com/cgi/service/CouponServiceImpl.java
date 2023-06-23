package com.cgi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.model.Coupon;
import com.cgi.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService{
	
	@Autowired
	private CouponRepository couponRepository;

	@Override
	public Coupon createCoupon(Coupon coupon) {
		Coupon result = couponRepository.save(coupon);
		return result;
	}

	@Override
	public List<Coupon> getAllCoupons() {
		List<Coupon> result = couponRepository.findAll();
		return result;
	}

	@Override
	public Optional<Coupon> getCouponByCode(int id) {
		Optional<Coupon> result = couponRepository.findById(id);
		return result;
	}

}
