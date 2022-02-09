package global.sesoc.ajax.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import global.sesoc.ajax.vo.Person;

@Controller
public class AjaxController {
	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	
	@ResponseBody
	@RequestMapping(value = "/btkky", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public Person kkyTest(@RequestBody Person person) {
		logger.debug("btkky 들어옴 {}", person);
//		logger.debug("btkky 들어옴 {}, {}", name, pw);
		return person;
	}
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1() {
		logger.debug("test1 들어옴");
		return "test1";
	}
	
	@ResponseBody
	@RequestMapping(value = "/ajaxtest1", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public String ajaxtest1() {
		logger.debug("ajaxtest1 들어옴");
		String str = "성공!";
		return str;
	}
	
	@ResponseBody
	@RequestMapping(value = "/ajaxtest2", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public String ajaxtest2(String name) {
		logger.debug("전달된 이름: {}", name);
		
		return "서버에서 보낸 값";
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2() {
		logger.debug("test2 들어옴");
		return "test2";
	}
	
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public String test3() {
		logger.debug("test3 들어옴");
		return "test3";
	}
}
