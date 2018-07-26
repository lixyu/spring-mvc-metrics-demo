package com.vcredit.lee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

@RestController
@RequestMapping("/influx")
public class InfluxTestController {

	@RequestMapping("/test")
	@Timed()
	public String test() {

		return "testClass";
	}

	@RequestMapping("/test2")
	@Timed(name = "influx")
	public String test2() {

		return "testClass";
	}
}
