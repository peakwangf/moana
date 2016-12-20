package com.peakwang.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import javax.servlet.http.HttpSession;

/**
 * 控制器Controller
 * 
 * @author peakwang
 *
 */
@Controller
public class IndexController {
//	private final Logger logger = Logger.getLogger(IndexController.class);
	public static final String BASE_PATH = ContextLoader
			.getCurrentWebApplicationContext().getServletContext()
			.getRealPath("/");

	/**
	 * 首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String indexInit(ModelMap model) {
		return "index";
	}
	
}
