package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.po.ItemsCustom;
import com.ssm.service.ItemService;

/**
* @Description 测试RESTful风格的url
* @author 欧阳
* @since 2018年12月16日 下午4:23:32
* @version V1.0
*/

@Controller
@RequestMapping("/rest")
public class TestRESTController {
	
	@Autowired
	private ItemService itemService;
	
	//查询商品
	@RequestMapping(value="/items/{id}",method=RequestMethod.GET)
	public @ResponseBody ItemsCustom findItems(@PathVariable(value="id") Integer id) 
			throws Exception {
		ItemsCustom itemsCustom = itemService.findItemsById(id);
		
		System.out.println("执行了查询商品操作");
		
		return itemsCustom;
	}
	
	//添加商品
	@RequestMapping(value="/items",method=RequestMethod.POST)
	public @ResponseBody ItemsCustom saveItems(ItemsCustom itemsCustom) 
			throws Exception {
		System.out.println("执行了添加商品操作");
		
		return itemsCustom;
	}
	
	//修改商品
	@RequestMapping(value="/items",method=RequestMethod.PUT)
	public @ResponseBody ItemsCustom updateItems(ItemsCustom itemsCustom) 
			throws Exception {
		System.out.println("执行了修改商品操作");
		
		return itemsCustom;
	}
	
	//删除商品
	@RequestMapping(value="/items",method=RequestMethod.DELETE)
	public @ResponseBody ItemsCustom deleteItems(Integer id) 
			throws Exception {
		System.out.println("执行了删除商品操作");
		
		//假定为删除商品 Service
		ItemsCustom itemsCustom = itemService.findItemsById(id);
		
		return itemsCustom;
	}
}
