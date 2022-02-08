package global.sesoc.cashbook.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import global.sesoc.cashbook.dao.MemberDAO;
import global.sesoc.cashbook.HomeController;
import global.sesoc.cashbook.dao.CashbookDAO;
import global.sesoc.cashbook.vo.MemberVO;
import global.sesoc.cashbook.vo.TotalVO;
import global.sesoc.cashbook.vo.CashbookVO;

@Controller
public class CashbookController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	CashbookDAO cashbookDAO;
	
	@RequestMapping(value = "/cashbook", method = RequestMethod.GET)
	public String moneybook(Model model, HttpSession session) {
		String id = (String) session.getAttribute("loginId");
		ArrayList<CashbookVO> list = cashbookDAO.select(id);
		model.addAttribute("list", list);
		return "cashbook";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(CashbookVO vo, HttpSession session) {
		String id = (String) session.getAttribute("loginId");
		vo.setUserid(id);
		
		logger.debug("저장할 값 {}", vo);
		cashbookDAO.insert(vo);
		return "redirect:/cashbook";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(CashbookVO vo, HttpSession session) {
		String id = (String) session.getAttribute("loginId");
		vo.setUserid(id);
		cashbookDAO.delete(vo);
		return "redirect:/cashbook";
	}

	@RequestMapping(value = "/total", method = RequestMethod.GET)
	public String searchDate(HttpSession session, Model model) {
		String id = (String) session.getAttribute("loginId");
		ArrayList<TotalVO> list = cashbookDAO.total(id);
		model.addAttribute("list", list);
		return "total";
	}	
	
}
