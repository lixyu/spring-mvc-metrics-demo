package com.vcredit.lee.test;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class InfluxDBTest {
	public static void main(String[] args) {
		new InfluxDBTest().write();
		new InfluxDBTest().getTest();
	}

	public void createDatabase() {
		String url = "http://10.138.60.8:8086/query";

		MultiValueMap<String, String> postParameter = new LinkedMultiValueMap<String, String>();

		postParameter.add("q", "CREATE DATABASE mydb1");

		RestTemplate restTemplate = new RestTemplate();

		restTemplate.postForObject(url, postParameter, Object.class);

	}

	public void write() {
		String url = "http://10.138.60.8:8086/write?db=mydb1";

		String pointValue = "test,host=server02,region=us-west value=0.64 1434055562000000000";

		RestTemplate restTemplate = new RestTemplate();

		restTemplate.postForObject(url, pointValue, Object.class);
	}

	public void getTest() {
		RestTemplate restTemplate = new RestTemplate();

		String url = "http://10.138.60.8:8086/query?pretty=true&q=select * from test&db=mydb1";

		String points = restTemplate.getForObject(url, String.class);

		System.out.println("points:" + points);
	}
}