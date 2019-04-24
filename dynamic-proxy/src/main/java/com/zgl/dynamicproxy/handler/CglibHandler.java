package com.zgl.dynamicproxy.handler;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zgl
 * @date 2019/4/24 下午9:35
 */
public class CglibHandler implements MethodInterceptor {

	public void setTarget(Object target) {
		this.target = target;
	}

	private Object target;

	public CglibHandler(Object target) {
		this.target = target;
	}
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("开始事务...");

		//执行目标对象的方法
		Object returnValue = method.invoke(target, args);

		System.out.println("提交事务...");

		return returnValue;
	}
}