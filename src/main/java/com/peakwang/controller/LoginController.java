package com.peakwang.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import javax.servlet.http.HttpSession;

import com.peakwang.model.User;
/**
 * 控制器Controller
 * 
 * @author peakwang
 *
 */
@Controller
public class LoginController {
	//private final Logger logger = Logger.getLogger(LoginController.class);
	public static final String BASE_PATH = ContextLoader
			.getCurrentWebApplicationContext().getServletContext()
			.getRealPath("/");

	
	/**
	 * 登陆界面
	 * 
	 * @return
	 */
	@RequestMapping(value="/login")
	public String login(ModelMap model,HttpSession session){
		User user=(User) session.getAttribute("user");
		if(user!=null){
			return "redirect:/index";
		}
		else{
			return "login";
		}
	}
	
	
}
