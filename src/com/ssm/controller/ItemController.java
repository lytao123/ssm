package com.ssm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.po.ItemsCustom;
import com.ssm.service.ItemService;

/**
* @Description 商品Controller
* @author 欧阳
* @since 2018年11月18日 上午12:34:15
* @version V1.0
*/

@Controller
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	//商品查询
	@RequestMapping(value="/queryItems")
	public String queryItems(ItemsCustom itemsCustom, Model model) throws Exception {
		System.out.println("itemsCustom = " + itemsCustom);
		//1.调用service 查找数据库的商品查询
		List<ItemsCustom> itemsList = itemService.findItemsList(null);
		model.addAttribute("itemsList", itemsList);
		
		return "itemsList";
	}
	
	//根据id查询商品信息
	@RequestMapping(value="/queryItemsById",method=RequestMethod.GET)
	public ModelAndView queryItemsById(@RequestParam("id") Integer id) 
			throws Exception{
		
		ModelAndView modelAndView = new ModelAndView();
		ItemsCustom itemsCustom = itemService.findItemsById(id);
		modelAndView.addObject("itemsCustom", itemsCustom);
		modelAndView.setViewName("editItems");
		return modelAndView;
	}
	
	
	//保存商品信息
	@RequestMapping(value="/saveItems",method=RequestMethod.PUT)
	public String saveItems(Model model,
			@Valid ItemsCustom itemsCustom, BindingResult result) 
			throws Exception{
		System.out.println(itemsCustom);
		//获取校验的错误信息
		if(result.hasErrors()) {
			//输出错误信息
			List<ObjectError> allErrors = result.getAllErrors();
			for(ObjectError error : allErrors) {
				System.out.println(error.getCode());
				System.out.println(error.getDefaultMessage());
				//将每一条错误信息传到model中，以用来页面展示
				model.addAttribute(error.getCode(), error.getDefaultMessage());
			}
			//将全部错误信息传到model中，以用来页面展示
			model.addAttribute("allErrors", allErrors);
			return "editItems";
		}
		
		return "redirect:queryItems.action";
	}
	
}
