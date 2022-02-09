package com.sesoc.web3.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sesoc.web3.dao.MemberDAO;
import com.sesoc.web3.vo.MemberVO;


@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberDAO dao;
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String viewjoinform(){
		return "join";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(MemberVO vo){
		logger.debug("vo : {}", vo);
		
		int result = dao.insert(vo);
		if(result!=1) {
			return "join";
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id){
		logger.debug("delete");
		int result = dao.deleteMember(id);
		if(result!=1) {
			logger.debug("실패");
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info(String id, Model model){
		logger.debug("전달된 아이디:{}", id);
		MemberVO vo = dao.selectMember(id);
		model.addAttribute("info", vo);
		
		return "info";
	}
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	public String idCheck(){
		return "idCheck";
	}
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public String idCheck2(String searchId, Model model){
		MemberVO vo = dao.searchId(searchId);
		model.addAttribute("searchId", searchId);
		model.addAttribute("searchResult", vo);
		model.addAttribute("search", true);
		
		return "idCheck";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Model model){
		logger.info("search");
		ArrayList<MemberVO> vo = dao.search();
		model.addAttribute("searchAll", vo);
		
		return "list";
	}
	
}
