package global.sesoc.ajax.controller;


import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import global.sesoc.ajax.vo.Person;

/**
 * Ajax Test
 */
@Controller
@RequestMapping("aj")
public class AjaxController {
	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
		
	/**
	 * JSP 페이지로 이동
	 */
	@RequestMapping (value="test1", method=RequestMethod.GET)
	public String test1() {
		return "aj/test1";
	}

	/**
	 * JSP에서 Ajax 호출
	 */
	@ResponseBody
	@RequestMapping (value="ajaxtest1", method=RequestMethod.GET)
	public void ajaxtest1() {
		logger.info("서버 : ajaxtest1() 실행");
	}

	/**
	 * JSP에서 Ajax 호출 - 문자열 전달, 리턴
	 * produces : 리턴할 문자열에 대한 처리
	 */
	@ResponseBody
	@RequestMapping (value="ajaxtest2", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
	public String ajaxtest2(String str) {
		/*
		 * 문자열을 디코딩 해야 할 때
	  		try {
				str = URLDecoder.decode(str, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		*/
		logger.info("서버 : ajaxtest2() 실행 - {}", str);
		return "AjaxController의 ajaxtest2() 메소드에서 리턴";
	}

	/**
	 * JSP 페이지로 이동 2
	 */
	@RequestMapping (value="test2", method=RequestMethod.GET)
	public String test2() {
		return "aj/test2";
	}

	/**
	 * parameter를 각각의 변수로 전달
	 */
	@ResponseBody
	@RequestMapping (value="insert1", method=RequestMethod.POST)
	public void insert1(String name, String age, String phone) {
		logger.info("전달된 값 : name={} / age={} / phone={}", name, age, phone);
	}
	
	/**
	 * parameter를 VO 객체로 받기 1
	 */
	@ResponseBody
	@RequestMapping (value="insert2", method=RequestMethod.POST)
	public void insert2(@RequestBody Person person) {
		logger.info("전달된 객체1 : {}", person);
	}
	
	/**
	 * parameter를 VO 객체로 받기 2
	 */
	@ResponseBody
	@RequestMapping (value="insert3", method=RequestMethod.POST)
	public void insert3(Person person) {
		logger.info("전달된 객체2 : {}", person);
	}

	/**
	 * 객체 리턴
	 */
	@ResponseBody
	@RequestMapping (value="jsontest", method=RequestMethod.GET)
	public Person jsontest() {
		Person person = new Person("홍길동", 20, "010-1111-2222");
		return person;
	}
	
	/**
	 * JSP 페이지로 이동 3
	 */
	@RequestMapping (value="test3", method=RequestMethod.GET)
	public String test3() {
		return "aj/test3";
	}

	/**
	 * 배열 전달
	 */
	@ResponseBody
	@RequestMapping (value="arrayTest1", method=RequestMethod.POST)
	public void arrayTest1(String ar[]) {
		if (ar == null) {
			logger.info("ar : null");
		}
		else {
			for (String s : ar) {
				logger.info("전달된 값 : {}", s);
			}
		}
	}
	
	/**
	 * 문자열 배열 리턴
	 */
	@ResponseBody
	@RequestMapping (value="arrayTest2", method=RequestMethod.GET)
	public String[] arrayTest2() {
		String array[] = {"하나", "둘", "셋"};
		return array;
	}
	
	/**
	 * 객체 배열 리턴
	 */
	@ResponseBody
	@RequestMapping (value="arrayTest3", method=RequestMethod.GET)
	public Person[] arrayTest3() {
		Person array[] = new Person[3];
		array[0] = new Person("김", 10, "1111");
		array[1] = new Person("이", 20, "2222");
		array[2] = new Person("박", 30, "3333");
		return array;
	}

}
