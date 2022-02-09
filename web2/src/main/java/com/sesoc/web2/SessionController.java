package com.sesoc.web2;

//java의 기본적인 객체
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SessionController {
	private static final Logger logger = LoggerFactory.getLogger(SessionController.class);
	
	//session테스트 1
	@RequestMapping(value = "/session1", method = RequestMethod.GET)
	public String sessionTest(HttpSession session) {
		logger.info("session1");
		session.setAttribute("id", "abc");
		session.setAttribute("name", "홍길동");
		return "redirect:/";
	}
	
	//session테스트 2
	@RequestMapping(value = "/session2", method = RequestMethod.GET)
	public String sessionTest2(HttpSession session) {
		logger.info("session2");
		session.removeAttribute("id");
		session.removeAttribute("name");
		return "redirect:/";
	}
}
