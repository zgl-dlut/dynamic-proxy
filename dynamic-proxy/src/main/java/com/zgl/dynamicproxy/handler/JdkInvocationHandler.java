package com.zgl.dynamicproxy.handler;

import com.zgl.dynamicproxy.util.DogUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zgl
 * @date 2019/4/24 下午9:33
 */
public class JdkInvocationHandler implements InvocationHandler {

	public void setTarget(Object target) {
		this.target = target;
	}

	private Object target;

	public JdkInvocationHandler(Object target){
		this.target=target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		DogUtil.method1();
		Object result=method.invoke(target,args);
		DogUtil.method2();
		return result;
	}
}