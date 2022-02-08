package global.sesoc.cashbook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.cashbook.dao.MemberDAO;
import global.sesoc.cashbook.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberDAO memberDAO;
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
		return "signupForm";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(MemberVO memberVO) {
		return "redirect:/";
	}
	

}
