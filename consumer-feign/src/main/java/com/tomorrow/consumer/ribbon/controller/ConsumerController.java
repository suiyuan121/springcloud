package com.tomorrow.consumer.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author zhangjin
 * @date 2018-07-05
 */
@RestController
public class ConsumerController {

	@Autowired
	private ServiceAFeignClient serviceAFeignClient;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String consumer(String name) {
		System.out.println(new Date() + "&&&&&&&&&&&&&&&&&");
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return serviceAFeignClient.hello(name);
	}


	@Component
	@FeignClient(value = "service-a", fallback = ServiceAFeignClientFallback.class)
	public interface ServiceAFeignClient {

		@RequestMapping(method = RequestMethod.GET, value = "/hello")
		String hello(@RequestParam("name") String name);

	}

	@Component
	public class ServiceAFeignClientFallback implements ServiceAFeignClient {

		@Override
		public String hello(String name) {
			return "this is fallback " + new Date();
		}

		public String hello(String name, Throwable e) {
			e.printStackTrace();
			return "this is fallback with exception" + new Date();
		}
	}
}
