package com.peakwang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.ui.ModelMap;


import com.peakwang.service.IndexService;
import com.peakwang.model.MovieTicket;

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
    @RequestMapping({"/index"})
    public String index() {
        return "index";
    }
	
	/**
     * 获取电影票列表
     * @return 电影票列表
     */
    @RequestMapping("list")
    @ResponseBody
    public List<MovieTicket> list() {
        List<MovieTicket> movieTicket = indexService.getAllMovieTicket();
        return movieTicket;
    }
}
