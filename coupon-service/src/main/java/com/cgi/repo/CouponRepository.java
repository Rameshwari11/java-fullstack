package com.cgi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cgi.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon,Long> {
	
	@Query
	public Coupon findByCode(String code);

}
