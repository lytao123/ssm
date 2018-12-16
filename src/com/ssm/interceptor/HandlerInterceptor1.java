package com.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptor1 implements HandlerInterceptor {
	
	/* 
	多个拦截器（以两个为例且拦截器1在前拦截器2在后，如下配置所示）执行顺序
	1.拦截器1放行，拦截器2放行：
	HandlerInterceptor1 ... preHandle
	HandlerInterceptor2 ... preHandle
	
	HandlerInterceptor2 ... postHandle
	HandlerInterceptor1 ... postHandle
	
	HandlerInterceptor2 ... afterCompletion
	HandlerInterceptor1 ... afterCompletion
	
	preHandle按配置顺序正序执行；
	postHandle 按配置倒序执行；
	afterCompletion 按配置倒序执行。
	
	2.拦截器1不放行，拦截器2放行：
	HandlerInterceptor1 ... preHandle
	
	拦截器1执行preHandle，拦截器2不执行preHandle；
	postHandle 都不执行；
	afterCompletion 都不执行。
	
	3.拦截器1放行，拦截器2不放行：
	HandlerInterceptor1 ... preHandle
	HandlerInterceptor2 ... preHandle
	HandlerInterceptor1 ... afterCompletion
	
	preHandle按配置顺序正序执行；
	postHandle 都不执行；
	拦截器1执行afterCompletion，拦截器2不执行afterCompletion。
	
	4.拦截器1不放行，拦截器2不放行：
	HandlerInterceptor1 ... preHandle
	
	拦截器1执行preHandle，拦截器2不执行preHandle；
	postHandle 都不执行；
	afterCompletion 都不执行。
	
 */
	
	/**
	 * controller执行前调用此方法 
	 * 返回true表示继续执行，返回false中止执行 
	 * 登录校验、权限拦截等
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println("HandlerInterceptor1 ... preHandle");
		
		//获取请求的url
		String url = request.getRequestURI();
		//判断url是否是公开 地址（实际使用时将公开地址配置配置文件中）
		if(url.indexOf("login.action") >= 0) {
			//如果进行登陆提交，放行
			return true;
		}
		
		//判断session
		HttpSession session = request.getSession();
		
		//从session中取出用户身份信息
		String username = (String) session.getAttribute("username");
		
		if(username != null && !"".equals(username)){
			//身份存在，放行
			return true;
		}
		
		//执行这里表示用户身份需要认证，跳转登陆页面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		
		return false;

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

		System.out.println("HandlerInterceptor1 ... postHandle");
		
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
		System.out.println("HandlerInterceptor1 ... afterCompletion");
		
	}

}
