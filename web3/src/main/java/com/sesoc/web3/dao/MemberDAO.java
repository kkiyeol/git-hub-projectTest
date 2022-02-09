package com.sesoc.web3.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesoc.web3.vo.MemberVO;

@Repository
public class MemberDAO {

	@Autowired
	SqlSession sqlSession;

	public int insert(MemberVO vo) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		int res=0;
		
		try{
			//마이바티스가 인터페이스 안에 insert라는 메서드를 정의를 해줌 
			res = mapper.insert(vo);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}

	public MemberVO searchId(String id) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		MemberVO vo = null;
		
		try {
			vo = mapper.searchId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return vo;
	}
	
	public ArrayList<MemberVO> search() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		ArrayList<MemberVO> vo = null;
		
		try {
			vo = mapper.search();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return vo;
	}
	
	public int deleteMember(String id) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		int result = 0;
		
		try {
			result = mapper.deleteMember(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	public MemberVO selectMember(String id) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		MemberVO result = null;
		
		try {
			result = mapper.selectMember(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
		
	}
}
