package global.sesoc.web4.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.web4.dao.GuestbookDAO;
import global.sesoc.web4.vo.Guestbook;

/**
 * 
 * @author kkiye
 *
 */
@Controller
public class GuestbookController {
	private static final Logger logger = LoggerFactory.getLogger(GuestbookController.class);
	
	@Autowired
	GuestbookDAO dao;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		ArrayList<Guestbook> list = dao.select();
		int maxNum = dao.selectMax();
		model.addAttribute("list", list);
		model.addAttribute("maxNum", maxNum);
		return "list";
	}
	
	/**
	 * 방명록 글쓰기 폼으로 이동
	 * @return 글쓰기 폼을 출력하는 write.jsp로 포워딩
	 */
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "write";
	}
	
	/**
	 * 방명록 글쓰기 폼에서 전달된 값을 DB에 저장
	 * @param book 글쓰기 폼에서 사용자가 작성한 글 내용
	 * @param vo, model
	 * @return 방명록 화면으로 리다이렉트
	 */
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String writeSave(Guestbook vo, Model model) {
		logger.debug("param: {}", vo);
		if(dao.insert(vo)==0) {
			return "write";
		}
		//이미 실행중인 경로로 강제로 보냄
		return "redirect:/list";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(int num, String password2) {
		logger.debug("ㅎㅇㅎㅇㅎㅇ");
		if(dao.delete(num, password2)==0) {
			logger.debug("삭제 실패");
		}else {
			logger.debug("삭제 성공");
		}
		return "redirect:/list";
	}
}
