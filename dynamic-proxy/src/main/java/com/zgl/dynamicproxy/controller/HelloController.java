package com.zgl.dynamicproxy.controller;

import com.zgl.dynamicproxy.aop.Proxy;
import com.zgl.dynamicproxy.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zgl
 * @date 2019/5/10 下午2:21
 */
@RestController
@Slf4j
@RequestMapping("/proxy")
public class HelloController {

	@Resource
	private StudentService studentService;

	@Proxy(value = "zyy")
	@GetMapping("/hello")
	public String hello(String id) {
		return studentService.getStudentById(id);
	}
}