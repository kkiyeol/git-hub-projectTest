package com.sesoc.web2;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestScope;

@Controller
public class JstlController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/jstl", method = RequestMethod.GET)
	public String jstlTest(Model model) {
		logger.info("jstl");
		int number = 100;
		String s = "abc";
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		
		String phone = "010-1111-2222";
		String data = "<marquee>문자열</marquee>";
		
		model.addAttribute("number", number);
		model.addAttribute("str", s);
		model.addAttribute("list", list);
		model.addAttribute("phone", phone);
		model.addAttribute("data", data);
		
		return "jstl";
	}
	
	@RequestMapping(value = "/jstl2", method = RequestMethod.GET)
	public String jstlTest2(Model model) {
		logger.info("jstl2");
		String s = "abc ABC 가나다라";
		model.addAttribute("str", s);
		
		return "jstl2";
	}

}
