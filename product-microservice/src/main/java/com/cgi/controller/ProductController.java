package com.cgi.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cgi.exception.MyCustomException;
import com.cgi.model.Coupon;
import com.cgi.model.Error;
import com.cgi.model.Product;
import com.cgi.service.ProductServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@ControllerAdvice
public class ProductController {
	

	private final ProductServiceImpl productServiceImpl;
	

	private final RestTemplate restTemplate;
	
	@ExceptionHandler(value = MyCustomException.class)
	public ResponseEntity<?> handleException(MyCustomException e)
	{
		Error error=new Error(HttpStatus.NOT_FOUND.value(),"CouponCode is Not Found",System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@PostMapping("/createProduct")
	public ResponseEntity<?> createProduct(@RequestBody Product product)
	{
		System.out.println("outside coupon");
		Coupon coupon=restTemplate.getForObject				("http://localhost:8083/coupon-microservice/findCouponByCode/{couponCode}",
						Coupon.class,
						Map.of("couponCode",product.getCouponCode()));	
		
		if(coupon==null)
		{
			System.out.println("iside coupon");
			throw new MyCustomException("CouponCode  "+ product.getCouponCode()+" not found");
		}
		System.out.println("success coupon");
		
		product.setDiscount(coupon.getDiscount());
		product.setProductPrice(product.getProductPrice()-product.getDiscount());
		return ResponseEntity.status(HttpStatus.CREATED).body(productServiceImpl.createProduct(product));
	}

}
