package com.lyz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 首页controller，主要的功能是跳转到首页
 * @author liuyazhuang
 *
 */
@Controller
@RequestMapping(value="/index")
public class IndexController {
	
	/**
	 * 跳转到首页
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public String page(HttpServletRequest request, HttpServletResponse response){
		return "/index";
	}
	
}
