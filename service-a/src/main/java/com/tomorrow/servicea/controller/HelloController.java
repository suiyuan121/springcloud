package com.tomorrow.servicea.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author zhangjin
 * @date 2018-07-05
 */
@RestController
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(String name) {
		System.out.println(new Date() + "**************");
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return "service-a:" + new Date() + "hello," + name + "!!!";
	}
}
