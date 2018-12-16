package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.exception.CustomException;
import com.ssm.exception.MyException;

/**
* @Description 类描述
* @author 欧阳
* @since 2018年12月15日 下午7:36:58
* @version V1.0
*/

@Controller
@RequestMapping("/exception")
public class ExceptionController {
	
	private final static String SUCCESS = "success";  //返回结果
	private final static String ERROR = "error";  //返回结果
	
	
	//方式一  继承 HandlerExceptionResolver
	//测试捕获全局异常
	@RequestMapping(value="/testException",method=RequestMethod.GET)
	public ModelAndView testException() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		if(!"".equals(SUCCESS)) {
			//抛出异常
			throw new CustomException("测试异常捕获方式一。");
		}
		
		modelAndView.setViewName(SUCCESS);
		
		return modelAndView;
	}
	
	
	/**
	 * 方式二，@ExceptionHandler 可用来捕获单个Controller中的异常
	 * @param e
	 * @return
	 */
	//用于处理异常
	@ExceptionHandler(value={MyException.class})
	public /*@ResponseBody*/ String exception(Exception e) {
		System.out.println(e.getMessage());
		
		return ERROR;
//		return e.getMessage();
	}
	
	@RequestMapping("/testException2")
	public ModelAndView testException2() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		if(!"".equals(SUCCESS)) {
			throw new MyException("测试错误，方式二");
		}
		
		modelAndView.setViewName(SUCCESS);
		return modelAndView;
	}
	
	/*
	 * 方式三：GlobalExceptionHandler类，
	 * @ControllerAdvice和@ExceptionHandler配合使用全局异常捕获
	 */
	@RequestMapping("/testException3")
	public ModelAndView testException3() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		if(!"".equals(SUCCESS)) {
			throw new Exception("Exception! thrid");
		}
		
		modelAndView.setViewName(SUCCESS);
		return modelAndView;
	}
}
