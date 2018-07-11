package com.vcredit.lee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

@RestController
@Timed
public class MyMetricsTest {

	@RequestMapping("/api/people")
	// @Timed(extraTags = { "region", "us-east-1" })
	// @Timed(value = "all.people", longTask = true)
	public String listPeople() {
		return "my metric test";
	}
}
