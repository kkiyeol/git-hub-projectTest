package com.sesoc.web2;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CookieController {
	private static final Logger logger = LoggerFactory.getLogger(CookieController.class);
	
	@RequestMapping(value = "/cookie1", method = RequestMethod.GET)
	public String cookieTest(HttpServletResponse res) {
		logger.info("cookie1");
		//쿠키생성
		Cookie c1 = new Cookie("num", "1234");
		Cookie c2 = new Cookie("str", "abcd");
		c1.setMaxAge(60*60*24*3);
		c2.setMaxAge(60*60*24*3);
		
		//클라이언트로 쿠키 저장
		res.addCookie(c1);
		res.addCookie(c2);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/cookie2", method = RequestMethod.GET)
	public String cookieTest2(HttpServletResponse res) {
		logger.info("cookie2");
		//쿠키 삭제하는 기능은 없고,
		//같은 이름으로 유지시간이 0초인 쿠키를 생성
		Cookie c1 = new Cookie("num", null);
		Cookie c2 = new Cookie("str", null);
		c1.setMaxAge(0);
		c2.setMaxAge(0);
		
		//클라이언트로 저장하여 덮어 쓴다.
		res.addCookie(c1);
		res.addCookie(c2);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/cookie3", method = RequestMethod.GET)
	public String cookieTest3(@CookieValue(value="num", defaultValue="0") 
	int num, @CookieValue(value="str", defaultValue = "") String str) {
		logger.info("cookie3");
		logger.debug("쿠키 num값:{}", num);
		logger.debug("쿠키 str값:{}", str);
		return "redirect:/";
	}
}
