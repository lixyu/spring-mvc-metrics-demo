package com.vcredit.lee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codahale.metrics.MetricRegistry;
import com.vcredit.lee.innotation.MyMeter;

@Service
public class FooTest {

	@Autowired
	private MetricRegistry metricRegistry;

	@MyMeter("test-service-meter")
	public void testMeter() {

	}

	@MyMeter("test2-service-meter")
	public void test2Meter() {

	}

	public void testCounter() {
		metricRegistry.counter("test-counter").inc();
		System.out.println("------------``````````-------------------");
		/* … */ }

	/*
	 * public void baz() { this.bar(); // doesn't pass through the proxy
	 * 
	 * // fix: reengineer // workaround: enable `expose-proxy` and change to:
	 * ((FooTest) AopContext.currentProxy()).bar(); // hideous, but it works }
	 */
}
