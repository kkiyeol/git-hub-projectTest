package global.sesoc.web99.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import global.sesoc.web99.dao.BoardDAO;
import global.sesoc.web99.vo.Board;

@Controller
@RequestMapping("board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardDAO dao;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {
		ArrayList<Board> list = dao.list();
		model.addAttribute("list", list);
		logger.debug("list목록: {}", list);
		return "boardjsp/list";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write() {
		return "boardjsp/write";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(HttpSession session, Model model, Board board, MultipartFile upload) {
		String id = (String) session.getAttribute("loginId");
		board.setId(id);
		
		dao.insertBoard(board);
		return "redirect:list";
	}
	
	@RequestMapping(value = "read", method = RequestMethod.GET)
	public String read(int num, Model model) {
		Board board = dao.read(num);
		model.addAttribute("board", board);
		return "boardjsp/read";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(int boardnum, Model model, HttpSession session) {
		Board board = dao.read(boardnum);
		model.addAttribute("board", board);
		return "boardjsp/updateForm";
	}
	
	@RequestMapping (value="update", method=RequestMethod.POST)
	public String edit(
			HttpSession session
			, Board board
			, MultipartFile upload) {
		
		//수정할 글이 로그인한 본인 글인지 확인
		String id = (String) session.getAttribute("loginId");
		Board oldBoard = dao.read(board.getBoardnum());
		if (oldBoard == null || !oldBoard.getId().equals(id)) {
			return "redirect:list";
		}
		
		//수정할 정보에 로그인 아이디 저장
		board.setId(id);
		
		//글 수정 처리
		dao.updateBoard(board);
		//원래의 글읽기 화면으로 이동 
		return "redirect:read?num=" + board.getBoardnum();
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(HttpSession session, int boardnum) {
		String id = (String) session.getAttribute("loginId");
		Board board = new Board();
		board.setBoardnum(boardnum);
		board.setId(id);
		int result = dao.deleteBoard(board);
		
		return "redirect:list";
	}
}
