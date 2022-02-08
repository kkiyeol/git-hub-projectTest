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
	
	/**
	 * 회원가입 폼으로 이동
	 * @return
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
		return "signupForm";
	}
	
	/**
	 * 회원가입 처리
	 * @param memberVO 가입양식에서 사용자가 입력한 정보
	 * @return 홈으로 리다이렉트
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(MemberVO member) {
		memberDAO.insert(member);
		return "redirect:/";
	}
	
	/**
	 * 로그인 폼으로 이동
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "loginForm";
	}
	
	/**
	 * 로그인 처리
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberVO member, HttpSession session) {
		MemberVO resultMember = memberDAO.getMember(member.getUserid());
		
		if (resultMember != null && member.getUserpwd().equals(resultMember.getUserpwd())) {
			session.setAttribute("loginId", member.getUserid());
		}
		return "redirect:/";
	}
	
	/**
	 * 로그아웃
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");
		return "redirect:/";
	}
	
}
