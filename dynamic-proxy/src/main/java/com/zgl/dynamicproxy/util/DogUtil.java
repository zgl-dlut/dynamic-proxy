package com.zgl.dynamicproxy.util;

/**
 * @author zgl
 * @date 2019/4/24 下午9:34
 */
public class DogUtil {

	public static void method1(){
		System.out.println("=========模拟通用方法1==========");
	}
	public static void method2(){
		System.out.println("=========模拟通用方法2==========");
	}
	public void method3(){
		System.out.println("=========cglib非静态方法代理==========");
	}
}