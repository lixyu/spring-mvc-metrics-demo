package com.vcredit.lee.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyXmlServiceAop {

	public void beforeHandler(String name, int age) {
		System.out.println("前置通知:" + name + ":age=" + age);
	}

	public Object aroundHandler(ProceedingJoinPoint jointPoint) {
		Object object = null;
		try {
			System.out.println("环绕通知开始");
			object = jointPoint.proceed();
			// jointPoint.proceed();
			System.out.println("name" + "环绕通知结束");

		} catch (Throwable e) {
		}
		return object;
	}

	public void afterHandler() {
		System.out.println("后置通知");
	}

	public void returnHandler(Object name) { // 在返回通知中获取返回值
		System.out.println("返回通知:" + name);
	}

	public void throwExceptionHandler(Throwable ex) {
		System.out.println("异常通知:" + ex.getMessage());
	}
}
