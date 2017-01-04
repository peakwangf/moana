package com.peakwang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.ui.ModelMap;

import com.peakwang.service.UserService;
import com.peakwang.model.RecordVo;
import com.peakwang.model.User;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public static final String BASE_PATH = ContextLoader
			.getCurrentWebApplicationContext().getServletContext()
			.getRealPath("/");
	
	@RequestMapping("userindex")
	public String userindex(ModelMap model,HttpServletRequest request){
		HttpSession session=request.getSession();
    	User user=(User)session.getAttribute("user");
		List<RecordVo> list = userService.getRecordsByUid(user.getUid());
		int leftNum=userService.getUserById(user.getUid()).getLeftGrabNum();
		model.addAttribute("leftNum", leftNum);
		if(list.size()>0){
			model.addAttribute("list", list);
		}else{
			model.addAttribute("userPageInfo", "您还没有抢购电影票！");
		}
        return "userPage";
	}
	
	
}
