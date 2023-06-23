package com.cgi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showIndex()
	{
		return "index";
	}
	
	@RequestMapping(method =RequestMethod.POST,path = "/hello")
	public String sayHello(@RequestParam("t1") String str,Model theModel)
	{
		System.out.println(str);
		//request.setAttribute("ATTR1", request.getParameter("t1"));
		
		theModel.addAttribute("ATTR1",str );
		return "hello";
	}
	
	@RequestMapping(method =RequestMethod.POST,path = "/welcome")
	public String submit(HttpServletRequest request)
	{
		request.setAttribute("ATTR2", request.getParameter("t2"));
		request.setAttribute("ATTR3", request.getParameter("t3"));
		request.setAttribute("ATTR4", request.getParameter("t4"));
		return "welcome";
	}

}