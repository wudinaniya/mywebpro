package com.qx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qx.service.UserService;
import com.qx.utils.UserMutate;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/findAll")
	public ModelAndView findAllUser(){
		ModelAndView mv=new ModelAndView();
		
		List<UserMutate> userMutates = userService.findAll();
		mv.addObject("usermutates", userMutates);
		mv.setViewName("/userlist");
		return mv;
		
	}
}

