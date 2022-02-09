package global.sesoc.ajax.controller;


import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import global.sesoc.ajax.dao.CommentDAO;
import global.sesoc.ajax.vo.Comment;

/**
 * Ajax Test - 리플달기
 */
@Controller
@RequestMapping ("aj")
public class CommentController {
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	CommentDAO dao;
	
	/**
	 * JSP 페이지로 이동
	 */
	@RequestMapping (value="comment", method=RequestMethod.GET)
	public String comment() {
		return "aj/comment";
	}

	/**
	 * 리플 저장
	 */
	@ResponseBody
	@RequestMapping (value="insert", method=RequestMethod.POST)
	public void insert(@RequestBody Comment comment) {
		logger.info("전달된 객체 : {}", comment);
		dao.insert(comment);
	}
	
	/**
	 * 목록 읽기
	 */
	@ResponseBody
	@RequestMapping (value="list", method=RequestMethod.GET)
	public ArrayList<Comment> list() {
		ArrayList<Comment> commentList = dao.list();
		return commentList;
	}
	
	/**
	 * 리플 삭제
	 */
	@ResponseBody
	@RequestMapping (value="delete", method=RequestMethod.POST)
	public int delete(int num) {
		logger.info("전달된 번호 : {}", num);
		int res = dao.delete(num);
		return res;
	}
}
