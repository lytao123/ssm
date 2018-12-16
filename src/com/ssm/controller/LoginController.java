package com.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	// 登陆页面
	@RequestMapping(value="/toLogin",method=RequestMethod.GET)
	public String login() throws Exception {

		//跳转登陆页面
		return "login";
	}
		
	// 登陆
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(HttpSession session, String username, String password)
			throws Exception {

		// 调用service进行用户身份验证
		
		// 在session中保存用户身份信息
		session.setAttribute("username", username);
		// 重定向到商品列表页面
		return "success";
	}

	// 退出
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {

		// 清除session
		session.invalidate();

		// 重定向到商品列表页面
		return "error";
	}

}
