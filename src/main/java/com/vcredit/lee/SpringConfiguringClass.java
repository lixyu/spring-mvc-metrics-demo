package com.vcredit.lee;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.ScheduledReporter;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;

import metrics_influxdb.HttpInfluxdbProtocol;
import metrics_influxdb.InfluxdbReporter;

@Configuration
@EnableMetrics
public class SpringConfiguringClass extends MetricsConfigurerAdapter {
	@Override
	public void configureReporters(MetricRegistry metricRegistry) {
		// ConsoleReporter.forRegistry(metricRegistry).build().start(1,
		// TimeUnit.MINUTES);
		InfluxdbReporter.forRegistry(metricRegistry)
				.protocol(new HttpInfluxdbProtocol("10.138.60.38", 8086, "test", "test"))
				.convertRatesTo(TimeUnit.SECONDS).convertDurationsTo(TimeUnit.MILLISECONDS).filter(MetricFilter.ALL)
				.skipIdleMetrics(false).tag("server", "127.0.0.1").build().start(1, TimeUnit.SECONDS);

	}

	@Bean(name = "influxdbReporter")
	public ScheduledReporter influxdbReporter(MetricRegistry metricRegistry) throws Exception {

		return InfluxdbReporter.forRegistry(metricRegistry)
				.protocol(new HttpInfluxdbProtocol("10.138.60.38", 8086, "", "", "test"))
				.convertRatesTo(TimeUnit.SECONDS).convertDurationsTo(TimeUnit.MILLISECONDS).filter(MetricFilter.ALL)
				.skipIdleMetrics(false).tag("server", "127.0.0.1").build();
	}

}
