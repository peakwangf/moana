package com.peakwang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peakwang.service.UserService;
import com.peakwang.model.Record;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("userindex")
	public String userindex(int uid){
		List<Record> records = userService.getRecordsByUid(uid);
		return "userPage";
	}
}
