package com.peakwang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.ContextLoader;

import com.peakwang.model.User;
import com.peakwang.service.LoginService;
import com.peakwang.service.UserService;
import com.peakwang.util.MD5;

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
	@Autowired
	private UserService userService;
	
	
	public static final String BASE_PATH = ContextLoader.getCurrentWebApplicationContext().getServletContext()
			.getRealPath("/");

	@RequestMapping(value = "/login")
	public String login(ModelMap model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null)
			return "redirect:/list";
		else
			return "login";
	}
	@RequestMapping(value = "/register")
	public String register() {
			return "register";
	}
	@RequestMapping(value = "/test")
	public String test(ModelMap model, HttpSession session) {
			return "test2";
	}
	/**
	 * 登陆验证
	 * 
	 * @return
	 */
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(ModelMap model, HttpSession session, String username, String password)  {
		String params=null;
		if (username != null && username.length() > 0) { 
			params=username;
		}else{
			model.addAttribute("loginInfo", "用户名不能为空！");
			return "login";
		}
		if (password != null && password.length() > 0) {
			password = MD5.EncoderByMd5(password);
		}else{
			model.addAttribute("loginInfo", "密码不能为空！");
			return "login";
		}
		List<User> users = null;
		users = loginService.loginByUsername(params);
		if (users.size() > 0) {
			if (password.equals(users.get(0).getPassWord())) {
				session.setAttribute("user", users.get(0));
				
				return "redirect:/list";
			} else {
				model.addAttribute("loginInfo", "对不起，您输入的密码错误。");
			}
		} else {
			model.addAttribute("loginInfo", "对不起，您输入的账户不存在或者密码错误。");
		}

		return "login";
	}
	/**
	 * 注册新用户
	 * 
	 * @return
	 */
	@RequestMapping(value = "/doRegister", method = RequestMethod.POST)
	public String doRegister(ModelMap model,String username, String email,String password){
		List<User> users = null;
		users = loginService.loginByUsername(username);
		if (users.size() > 0) {
			model.addAttribute("registerInfo", "该用户名已存在！");
			return "register";
		}
		User user=new User();
		user.setUserName(username);
		user.setEmail(email);
		user.setPassWord(MD5.EncoderByMd5(password));
		user.setLeftGrabNum(2);
		userService.add(user);
		model.addAttribute("loginInfo", "注册成功，请登录！");
		return "login";
	}
	/**
	 * 注销
	 * 
	 * @return
	 */
	@RequestMapping(value = "/exit")
	public String exit(ModelMap model, HttpSession session) {
		// 注销登陆者session
		session.removeAttribute("user");
		return "login";
	}
	
}
