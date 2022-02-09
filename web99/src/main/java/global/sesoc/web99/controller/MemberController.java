package global.sesoc.web99.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import global.sesoc.web99.dao.MemberDAO;
import global.sesoc.web99.vo.Member;

@Controller
@RequestMapping("member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberDAO dao;
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		logger.debug("join");
		return "memberjsp/joinForm";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Member member) {
		logger.debug("가입 폼에서 전달된 값:{}", member);
		int result = dao.insert(member);
		if(result != 1) {
			return "memberjsp/joinForm";
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "idcheck", method = RequestMethod.GET)
	public String idcheck() {
		return "memberjsp/idcheck";
	}
	
	@RequestMapping(value = "idcheck", method = RequestMethod.POST)
	public String idcheck(String searchId, Model model) {
		Member member = dao.getMember(searchId);
		model.addAttribute("member", member);
		model.addAttribute("searchId", searchId);
		return "memberjsp/idcheck";
	}
	
	@ResponseBody
	@RequestMapping(value = "idCheck2", method = RequestMethod.POST)
	public String idcheck2(String id, Model model) {
		logger.debug("AJAX");
		Member member = dao.getMember(id);
		String msg = "";
		if(member != null) {
			model.addAttribute("member", member);
			model.addAttribute("checkId", id);
			msg = "x";
			logger.debug("ajax 넘겨받은 값:{}", id);
		}else {
			msg = "o";
		}
		logger.debug("최종: "+msg);
		return msg;
	}
	
	
	/**
	 * 로그인 폼으로 이동
	 */
	@RequestMapping (value="login", method=RequestMethod.GET)
	public String login() {
		return "memberjsp/loginForm";
	}

	/**
	 * 로그인 처리
	 */
	@RequestMapping (value="login", method=RequestMethod.POST)
	public String login(String id, String password, Model model, HttpSession session) {
		Member member = dao.getMember(id);
		
		//ID가 존재하고 비밀번호도 맞으면 세션에 ID와 이름을 저장하고 메인화면으로 리다이렉트
		if (member != null && member.getPassword().equals(password)) {
			session.setAttribute("loginId", member.getId());
			session.setAttribute("loginName", member.getName());
			return "redirect:/";
		}
		//ID가 없거나 비밀번호가 틀리면 로그인 화면으로 다시 포워딩
		else {
			model.addAttribute("errorMsg", "ID 또는 비밀번호가 틀립니다.");
			return "memberjsp/loginForm";
		}
	}
	
	/**
	 * 로그아웃
	 */
	@RequestMapping (value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");
		session.removeAttribute("loginName");
		return "redirect:/";
	}
	
	/**
	 * 개인정보 수정 폼으로 이동
	 */
	@RequestMapping (value="update", method=RequestMethod.GET)
	public String update(Model model, HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");
		Member member = dao.getMember(loginId);
		model.addAttribute("member", member);
		return "memberjsp/updateForm";
	}

	/**
	 * 개인정보 수정 처리
	 */
	@RequestMapping (value="update", method=RequestMethod.POST)
	public String update(Member member, Model model, HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");
		member.setId(loginId);;
		logger.debug("수정 데이터 : {}", member);
		
		int res = dao.updateMember(member);
		if (res != 0) {
			return "redirect:/";
		}
		else {
			return "memberjsp/updateForm";
		}
	}
}
