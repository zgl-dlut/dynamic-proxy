package com.zgl.dynamicproxy.factory;

import com.zgl.dynamicproxy.handler.JdkInvocationHandler;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/**
 * @author zgl
 * @date 2019/4/24 下午9:33
 */
public class JdkProxyFactory {

	/**
	 * 获取代理对象
	 */
	@SuppressWarnings("unchecked")
	public static <T>T getProxy(Object target)throws Exception{
		JdkInvocationHandler jdkInvocationHandler =new JdkInvocationHandler(target);
		jdkInvocationHandler.setTarget(target);
		return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), jdkInvocationHandler);
	}

	/**
	 * 获取目标对象
	 */
	@SuppressWarnings("unchecked")
	public static <T>T getTarget(Object proxy)throws Exception{
		Field field = proxy.getClass().getSuperclass().getDeclaredField("h");
		field.setAccessible(true);
		JdkInvocationHandler jdkInvocationHandler = (JdkInvocationHandler) field.get(proxy);
		Field target = jdkInvocationHandler.getClass().getDeclaredField("target");
		target.setAccessible(true);
		return (T)target.get(jdkInvocationHandler);
	}

}