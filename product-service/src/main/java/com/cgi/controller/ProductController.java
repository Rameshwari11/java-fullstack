package com.cgi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import com.cgi.dto.Coupon;
import com.cgi.model.Product;
import com.cgi.repository.ProductRepository;


@RestController
public class ProductController {	

	private ProductRepository repo;

	private RestTemplate restTemplate;
	
	public ProductController(ProductRepository repo, RestTemplate restTemplate) {
		super();
		this.repo = repo;
		this.restTemplate = restTemplate;
	}


	@Value("${couponService.url}")
	private String couponServiceURL;

	@PostMapping("/products")
	public Product create(@RequestBody Product product) {
		
		Coupon coupon = restTemplate.getForObject(
				couponServiceURL + 
				product.getCouponCode(), 
				Coupon.class);
		
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repo.save(product);

	}

}
