package com.zgl.dynamicproxy.factory;

import com.zgl.dynamicproxy.handler.CglibHandler;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Field;

/**
 * @author zgl
 * @date 2019/4/24 下午9:35
 */
public class CglibProxyFactory {
	/**
	 * 获取代理对象
	 */
	@SuppressWarnings("unchecked")
	public static <T>T getProxyInstance(Object target){
		CglibHandler cglibHandler=new CglibHandler(target);
		cglibHandler.setTarget(target);
		//1.工具类
		Enhancer en = new Enhancer();
		//2.设置父类
		en.setSuperclass(target.getClass());
		//3.设置回调函数
		en.setCallback(cglibHandler);
		//4.创建子类(代理对象)
		return (T)en.create();
	}
	/**
	 * 获取目标对象
	 */
	@SuppressWarnings("unchecked")
	public static <T>T getTarget(Object proxy)throws Exception{
		Field field = proxy.getClass().getDeclaredField("CGLIB$CALLBACK_0");
		field.setAccessible(true);
		CglibHandler cglibHandler = (CglibHandler) field.get(proxy);
		Field target = cglibHandler.getClass().getDeclaredField("target");
		target.setAccessible(true);
		return (T)target.get(cglibHandler);
	}
}