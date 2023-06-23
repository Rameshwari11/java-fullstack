package com.cgi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon,Integer> {

}
