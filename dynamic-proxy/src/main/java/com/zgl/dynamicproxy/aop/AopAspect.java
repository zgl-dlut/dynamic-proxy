package com.zgl.dynamicproxy.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zgl
 * @date 2019/5/10 下午2:19
 */
@Slf4j
@Aspect
@Component
public class AopAspect {

	@Pointcut("@annotation(com.zgl.dynamicproxy.aop.Proxy))")
	public void aopPointcut() {
	}

	@Before("aopPointcut()")
	public void beforeMethod(JoinPoint joinPoint) {
		Object[] params = joinPoint.getArgs();
		Map<Object, Object> paramsMap = new HashMap<>();
		for (Object object : params) {
			paramsMap.put(object, object.toString());
		}
		log.info("方法参数名:{}", paramsMap);
	}

	@Around("aopPointcut()")
	public void aroundMethod(ProceedingJoinPoint joinPoint) {
		log.info("环绕通知");
		try {
			joinPoint.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
	}

	@After("aopPointcut()")
	public void afterMethod(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		log.info("方法拦截的方法名字后：{}", method.getName());
	}
}