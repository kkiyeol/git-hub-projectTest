package com.sesoc.web1;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * 메인 화면
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("콘솔로 출력하는 메시지");
		
		return "home";
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testMethod(Model m) {
		logger.error("error로 출력함");
		logger.warn("warn로 출력함");
		logger.info("info로 출력함");
		logger.debug("debug로 출력함");
		
		int num = 100;
		String str = "abcd";
		double d = 1.2345;
		
		ArrayList<String> list = new ArrayList<>();
		list.add("aaaaa");
		list.add("bbbbb");
		list.add("ccccc");
		
		m.addAttribute("num", num);
		m.addAttribute("str", str);
		m.addAttribute("dnum", d);
		m.addAttribute("list", list);

		
		
		return "view";
	}
	
}
