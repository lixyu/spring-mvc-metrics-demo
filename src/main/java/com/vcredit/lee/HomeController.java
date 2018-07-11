package com.vcredit.lee;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.MetricRegistry;

/**
 * Handles requests for the application home page.
 */
@RestController
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private FooTest fooTest;
	@Autowired
	private MetricRegistry metricRegistry;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		metricRegistry.meter("test").mark();
		logger.info("Welcome home! The client locale is {}.", locale);

		fooTest.testCounter();

		return "home";
	}

	@RequestMapping(value = "/meter", method = RequestMethod.GET)
	public String meter(Locale locale, Model model) {

		fooTest.testMeter();

		return "home";
	}

	@RequestMapping(value = "/meter2", method = RequestMethod.GET)
	public String meter2(Locale locale, Model model) {

		fooTest.test2Meter();

		return "home2";
	}

	@RequestMapping(value = "/meter3", method = RequestMethod.GET)
	public String meter3(Locale locale, Model model) {

		fooTest.testMeter();

		return "home3";
	}

}
