package com.cgi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cgi.model.Customer;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@GetMapping("/")
	public String showForm(Model theModel)
	{
		theModel.addAttribute("customer", new Customer());
		return "showForm";
	}
	@RequestMapping(method = RequestMethod.POST,path = "/processForm")
	public String processForm(@ModelAttribute("customer") Customer customer, Model theModel)
	{
		theModel.addAttribute("c", customer);
		return "processForm";
	}
	

}
