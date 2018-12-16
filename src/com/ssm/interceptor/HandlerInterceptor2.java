package com.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptor2 implements HandlerInterceptor {

	/**
	 * controller执行前调用此方法 
	 * 返回true表示继续执行，返回false中止执行 
	 * 登录校验、权限拦截等
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("HandlerInterceptor2 ... preHandle");
		return true;
	}

	/**
	 * controller执行后,并且未返回ModelAndView前 调用此方法 
	 * 可在返回用户前对模型数据进行加工处理，
	 * 加入公用信息以便页面显示
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("HandlerInterceptor2 ... postHandle");
		
	}

	/**
	 * controller执行后且视图返回后调用此方法 
	 * 可得到执行controller时的异常信息 
	 * 记录操作日志，资源清理等
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("HandlerInterceptor2 ... afterCompletion");
		
	}

}
