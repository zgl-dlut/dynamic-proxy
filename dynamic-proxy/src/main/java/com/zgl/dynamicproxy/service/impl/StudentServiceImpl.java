package com.zgl.dynamicproxy.service.impl;

import com.zgl.dynamicproxy.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @author zgl
 * @date 2019/5/10 下午2:26
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Override
	public String getStudentById(String id) {
		return "zgl";
	}
}