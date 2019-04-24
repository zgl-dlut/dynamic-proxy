package com.zgl.dynamicproxy.service.impl;

import com.zgl.dynamicproxy.service.Dog;

/**
 * @author zgl
 * @date 2019/4/24 下午9:36
 */
public class GunDog implements Dog {

	@Override
	public void info() {
		System.out.println("我是一只猎狗!");
	}

	@Override
	public void run() {
		System.out.println("我跑的飞快!");
	}
}