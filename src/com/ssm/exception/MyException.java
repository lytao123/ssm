package com.ssm.exception;
/**
* @Description 自定义异常类
* @author 欧阳
* @since 2018年12月15日 下午8:43:42
* @version V1.0
*/

public class MyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyException(String message) {
		super(message);
	}

}
