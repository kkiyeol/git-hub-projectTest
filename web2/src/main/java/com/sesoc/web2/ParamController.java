package com.sesoc.web2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ParamController {
	private static final Logger logger = LoggerFactory.getLogger(ParamController.class);
	
	@RequestMapping(value = "/param1", method = RequestMethod.GET)
	public String paramTest(int num, String name) {
		logger.info("param");
		int number = num;
		String n = name;
		logger.info("number: "+num+" name: "+n);
		
		
		return "redirect:/";
	}
	
	//글쓰기 폼으로 이동
	@RequestMapping(value = "/param2", method = RequestMethod.GET)
	public String paramTest2() {
		return "writeForm";
	}
	
	//사용자 폼에서 전송된 parameter 받기
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String paramTest3(Person p) {
		logger.info("param2");
		logger.debug("Person:{}", p);
		
		return "redirect:/";
	}
	
}
