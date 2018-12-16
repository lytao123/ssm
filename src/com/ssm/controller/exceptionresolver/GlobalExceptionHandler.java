package com.ssm.controller.exceptionresolver;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @Description 实现全局的 Controller 层的异常处理，要保证能被扫描到并装载进 Spring 容器中。
* @author 欧阳
* @since 2018年12月15日 下午9:00:35
* @version V1.0
*/

@ControllerAdvice
public class GlobalExceptionHandler {
	
	/**
	 * 处理所有不可知的异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
    public @ResponseBody String handleException(Exception e){
		
        return "Exception! thrid";
    }
	
}
