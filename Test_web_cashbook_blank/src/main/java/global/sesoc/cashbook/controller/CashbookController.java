package global.sesoc.cashbook.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import global.sesoc.cashbook.dao.MemberDAO;
import global.sesoc.cashbook.dao.CashbookDAO;
import global.sesoc.cashbook.vo.MemberVO;
import global.sesoc.cashbook.vo.CashbookVO;

@Controller
public class CashbookController {
	
	@Autowired
	CashbookDAO cashbookDAO;
	
	@RequestMapping(value = "/cashbook", method = RequestMethod.GET)
	public String moneybook() {
		return "cashbook";
	}
	

}
