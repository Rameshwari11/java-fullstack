package com.cgi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cgi.model.Coupon;
import com.cgi.service.CouponServiceImpl;

@RestController
public class CouponController {

	@Autowired
	private CouponServiceImpl couponServiceImpl;

	@PostMapping("/createCoupon")
	private ResponseEntity<?> createCoupon(@RequestBody Coupon coupon) {
		Coupon result = couponServiceImpl.createCoupon(coupon);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@GetMapping("/getAllCoupons")
	private ResponseEntity<?> getAllDepartments() {
		List<Coupon> result = couponServiceImpl.getAllCoupons();
		return ResponseEntity.status(HttpStatus.OK).body(result);

	}

	@GetMapping("/findCouponByCode/{couponCode}")
	private ResponseEntity<?> getAllDepartments(@PathVariable int couponCode) {
		Optional<Coupon> result = couponServiceImpl.getCouponByCode(couponCode);
		if (result.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

}
