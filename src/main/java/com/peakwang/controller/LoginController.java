package com.peakwang.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.ContextLoader;

import com.peakwang.model.User;
import com.peakwang.service.LoginService;

/**
 * 控制器Controller
 * 
 * @author peakwang
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	public static final String BASE_PATH = ContextLoader.getCurrentWebApplicationContext().getServletContext()
			.getRealPath("/");

	@RequestMapping(value = "/login")
	public String login(ModelMap model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null)
			return "redirect:/index";
		else
			return "login";
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(ModelMap model, HttpSession session, String username, String password) {
		String params=null;
		if (username != null && username.length() > 0) {
			params=username;
		}
		if (password != null && password.length() > 0) {
			//password = MD5.EncoderByMd5(password);
		}
		List<User> users = null;
		users = loginService.loginByUsername(params);
		if (users.size() > 0) {
			if (password.equals(users.get(0).getPassword())) {
				session.setAttribute("user", users.get(0));
				return "redirect:/index";
			} else {
				model.addAttribute("loginInfo", "对不起，您输入的密码错误。");
			}
		} else {
			model.addAttribute("loginInfo", "对不起，您输入的账户不存在或者密码错误。");
		}

		return "login";
	}

}
