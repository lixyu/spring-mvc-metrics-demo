package com.vcredit.lee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/influx")
public class TestInfluxdb {

	public void writePoints() {
		String url = "http://10.138.60.8:8086/write?db=test";
		String pointValue = "pkk,name=pangkun1,address=shanghai age=21/n"
				+ "pkk,name=pangkun2,address=shanghai age=22/n" + "pkk,name=pangkun3,address=shanghai age=23";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(url, pointValue, Object.class);
	}

	public static void main(String[] args) {
		TestInfluxdb test = new TestInfluxdb();
		test.writePoints();
	}
}
