package com.peakwang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.peakwang.service.IndexService;
import com.peakwang.model.MovieTicket;
import com.peakwang.model.User;
 

/**
 * 控制器Controller
 * 
 * @author peakwang
 *
 */
@Controller
public class IndexController {
	@Autowired
	private IndexService indexService;


	
	public static final String BASE_PATH = ContextLoader
			.getCurrentWebApplicationContext().getServletContext()
			.getRealPath("/");

	 /**
     * 首页
     */
  
	
	/**
     * 获取电影票列表
     * @return 电影票列表
     */
    @RequestMapping("list")
    public String list(ModelMap model) {
        List<MovieTicket> movieTicket = indexService.getAllMovieTicket();
        model.addAttribute("list", movieTicket);
        return "index";
    }
    @RequestMapping("grab")
    public String grab(RedirectAttributesModelMap model,HttpServletRequest request, int tid) {
    	HttpSession session=request.getSession();
    	User user=(User)session.getAttribute("user");
    	String message=indexService.grab(user.getUid(), tid);
    	model.addFlashAttribute("errorInfo", message);
    	return "redirect:/list";     
    }
}
