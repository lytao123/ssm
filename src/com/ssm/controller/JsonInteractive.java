package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.po.Items;

/**
* @Description Json 交互
* @author 欧阳
* @since 2018年12月16日 上午9:22:35
* @version V1.0
*/

@Controller
@RequestMapping("/json")
public class JsonInteractive {
	
	@RequestMapping("requestJson")
	public @ResponseBody Items requestJson(@RequestBody Items items) {
		System.out.println(items);
		
		return items;
	}
	
	@RequestMapping("responseJson")
	public @ResponseBody Items responseJson(Items items) {
		
		return items;
	}
	
}
