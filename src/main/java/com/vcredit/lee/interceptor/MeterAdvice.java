package com.vcredit.lee.interceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.vcredit.framework.interceptor.AbstractAdvice;
import com.vcredit.framework.util.RandomUtil;

public class MeterAdvice extends AbstractAdvice {

	@Autowired
	private MetricRegistry metricRegistry;

	private String value;

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		/*
		 * MyMeter my = (MyMeter) AnnotationUtils.findAnnotation(invocation.getMethod(),
		 * QuartzJob.class); System.out.println(my.name());
		 */
		Meter meter = metricRegistry.meter(RandomUtil.random(5));
		meter.mark();
		System.out.println("===============MyMeter==============");
		return null;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
