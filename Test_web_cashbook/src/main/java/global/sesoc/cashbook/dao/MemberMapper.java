package global.sesoc.cashbook.dao;

import global.sesoc.cashbook.vo.MemberVO;

public interface MemberMapper {
	//회원 정보 저장
	public int insertMember(MemberVO member);
	//회원 정보 조회
	public MemberVO selectMember(String userid);

}
