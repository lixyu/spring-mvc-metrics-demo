package com.vcredit.lee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.codahale.metrics.annotation.Counted;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Gauge;
import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Metric;
import com.codahale.metrics.annotation.Timed;

@RestController
@RequestMapping("/spring")
public class SpringTestController {

	@Autowired
	private MetricRegistry metricRegistry;

	private int i = 0;

	@RequestMapping("/timed")
	@Timed(name = "test")
	public String testTimed() {
		Timer responses = metricRegistry.timer("test-timer");
		final Timer.Context context = responses.time();
		try {
			// etc;
			return "OK";
		} finally {
			context.stop();
		}
		// return "@Timed";
	}

	@RequestMapping("/counted")
	@Counted(monotonic = true)
	public String testCounted() {
		return "@Counted";
	}

	@RequestMapping("/exception")
	@ExceptionMetered(name = "fancyName", cause = Exception.class)
	@Counted(monotonic = true)
	public String testExceptionMetered() throws Exception {

		try {
			if (i % 2 == 0) {
				return "11";
			} else {
				throw new Exception();
			}

		} finally {
			i++;
		}

	}

	@RequestMapping("/gauge")
	@Gauge
	public String testGauge() {
		return "@Gauge";
	}

	@RequestMapping("/metered")
	@Metered
	public String testMetered() {
		return "@Metered";
	}

	@RequestMapping("/metric")
	@Metric
	public String testMetric() {
		return "@Metric";
	}
}
