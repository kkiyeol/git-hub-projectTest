package global.sesoc.cashbook.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.cashbook.vo.MemberVO;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * 회원 가입 처리
	 * @param member 사용자가 입력한 가입 정보
	 * @return 저장된 행 개수
	 */
	public int insert(MemberVO member) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		int result = mapper.insertMember(member);
		return result;
	}
	
	/**
	 * 회원 정보 검색
	 * @param id 검색할 회원 ID
	 * @return 검색결과를 담은 Member 객체
	 */
	public MemberVO getMember(String id) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		MemberVO member = mapper.selectMember(id);
		return member;
	}

}
