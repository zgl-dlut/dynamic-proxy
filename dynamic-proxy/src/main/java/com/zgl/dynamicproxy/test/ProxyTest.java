package com.zgl.dynamicproxy.test;

import com.zgl.dynamicproxy.factory.CglibProxyFactory;
import com.zgl.dynamicproxy.factory.JdkProxyFactory;
import com.zgl.dynamicproxy.service.Dog;
import com.zgl.dynamicproxy.service.impl.GunDog;
import com.zgl.dynamicproxy.util.DogUtil;

import java.lang.reflect.Field;

/**
 * @author zgl
 * @date 2019/4/24 下午9:36
 */
public class ProxyTest {
	public static void main(String[] args) throws Exception{

		Dog dog=new GunDog();
		Dog jdkProxy=JdkProxyFactory.getProxy(new GunDog());
		jdkProxy.info();
		jdkProxy.run();

		DogUtil cglibProxy=CglibProxyFactory.getProxyInstance(new DogUtil());
		cglibProxy.method3();

		/**
		 * class com.ioc.proxy.service.impl.GunDog
		 */
		System.out.println(dog.getClass());
		/**
		 * com.ioc.proxy.service.impl.GunDog
		 */
		System.out.println(dog.getClass().getName());
		/**
		 * class java.lang.Object
		 */
		System.out.println(dog.getClass().getSuperclass());
		/**
		 * com.ioc.proxy.service.impl.GunDog@1ff8b8f
		 */
		System.out.println(jdkProxy);
		/**
		 * class com.sun.proxy.$Proxy0
		 */
		System.out.println(jdkProxy.getClass());
		/**
		 * class java.lang.reflect.Proxy
		 */
		System.out.println(jdkProxy.getClass().getSuperclass());
		/**
		 * com.sun.proxy.$Proxy0
		 */
		System.out.println(jdkProxy.getClass().getName());
		/**
		 * com.ioc.proxy.service.impl.GunDog
		 */
		System.out.println(JdkProxyFactory.getTarget(jdkProxy).getClass().getName());
		/**
		 * class com.ioc.proxy.util.DogUtil$$EnhancerByCGLIB$$b35f93a3
		 */
		System.out.println(cglibProxy.getClass());
		/**
		 * class com.ioc.proxy.util.DogUtil
		 */
		System.out.println(cglibProxy.getClass().getSuperclass());
		/**
		 * com.ioc.proxy.util.DogUtil$$EnhancerByCGLIB$$b35f93a3
		 */
		System.out.println(cglibProxy.getClass().getName());
		/**
		 * com.ioc.proxy.util.DogUtil
		 */
		System.out.println(CglibProxyFactory.getTarget(cglibProxy).getClass().getName());

	}
}