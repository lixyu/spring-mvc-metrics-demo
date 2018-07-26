package com.vcredit.lee;

import org.springframework.stereotype.Service;

@Service
public class MetricsSpringTestService {

	// @Timed(name = "test-timed")
	// @Counted(monotonic = true)
	public void timedTest() {
		try {
			Thread.sleep(2 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
