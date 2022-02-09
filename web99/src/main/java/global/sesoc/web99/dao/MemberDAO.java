package global.sesoc.web99.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.web99.vo.Member;

@Repository
public class MemberDAO {
	@Autowired
	SqlSession sqlSession;
	
	public int insert(Member member) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		int result=0;
		result = mapper.insert(member);
		return result;
	}

	public Member getMember(String searchId) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		Member member = null;
		member = mapper.getMember(searchId);
		
		return member;
	}
	
	public int updateMember(Member member) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		int result = 0;

		try {
			result = mapper.updateMember(member);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
