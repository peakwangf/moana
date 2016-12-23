package com.peakwang.controller;

import org.springframework.stereotype.Controller;
import org.apache.log4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.ContextLoader;

import com.peakwang.model.User;
/**
 * 控制器Controller
 * 
 * @author peakwang
 *
 */
@Controller
public class LoginController {

	
	public static final String BASE_PATH = ContextLoader
			.getCurrentWebApplicationContext().getServletContext()
			.getRealPath("/");
	
	@RequestMapping(value="/login")
	public String login(ModelMap model,HttpSession session){
		User user=(User) session.getAttribute("user");
		if(user!=null)
			return "redirect:/index";
		else
			return "login";
	}

}
