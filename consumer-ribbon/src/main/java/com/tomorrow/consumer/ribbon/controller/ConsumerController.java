package com.tomorrow.consumer.ribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * @author zhangjin
 * @date 2018-07-05
 */
@RestController
public class ConsumerController {

	@Autowired
	private RestTemplate restTemplate;


	@Autowired
	private ConsumerService consumerService;


	@GetMapping("/")
	public String consumer(String name) {
		return restTemplate.getForObject("http://service-a/?name=" + name, String.class);
	}

	@GetMapping("/fallback")
	public String consumerWithFallback(String name) {
		return consumerService.consumer(name);
	}


	@Service
	public class ConsumerService {

		@Autowired
		RestTemplate restTemplate;


		//服务降级
		@HystrixCommand(fallbackMethod = "fallback")
		public String consumer(String name) {
			return restTemplate.getForObject("http://service-a/?name=" + name, String.class);
		}

		public String fallback(String name, Throwable e) {
			e.printStackTrace();
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			return "timeout ,this is fallback" + new Date();
		}

	}

}
