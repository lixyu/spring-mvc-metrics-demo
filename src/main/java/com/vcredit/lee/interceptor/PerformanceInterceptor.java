package com.vcredit.lee.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

public class PerformanceInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(PerformanceInterceptor.class);

	private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("performance");

	private final MetricRegistry metrics = new MetricRegistry();
	private final Meter requests = metrics.meter("requests");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		startTimeThreadLocal.set(System.currentTimeMillis());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		return;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long currentTime = System.currentTimeMillis();
		long executeTime = currentTime - startTimeThreadLocal.get();
		// logger.info("uri:{},执行了 {} ms", request.getRequestURI(), executeTime);
		// System.out.println(request.getRequestURL().toString());
	}

}
