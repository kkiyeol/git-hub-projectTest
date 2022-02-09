package com.sesoc.web3.dao;

import java.util.ArrayList;

import com.sesoc.web3.vo.MemberVO;

/*
 * 인터페이스를 상속을 받아 메서드를 구현을 하면 사용가능
 * */
public interface MemberMapper {
	//추상메서드 정의, 선언만 하면 mybatis가 코드를 구현해줌
	public int insert(MemberVO vo);
	
	public MemberVO searchId(String id);
	
	public ArrayList<MemberVO> search();

	public int deleteMember(String id);

	public MemberVO selectMember(String id);
}
