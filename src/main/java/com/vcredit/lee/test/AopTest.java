package com.vcredit.lee.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vcredit.lee.aop.MyXmlService;

public class AopTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/root-context.xml");
		MyXmlService service = (MyXmlService) context.getBean("myXmlService");
		String name = service.handlerXml("t6", 25);
		System.out.println(name);
	}
}
