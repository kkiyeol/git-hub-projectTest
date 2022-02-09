package global.sesoc.web99.dao;

import global.sesoc.web99.vo.Member;

public interface MemberMapper {

	public int insert(Member member);

	public Member getMember(String searchId);

	public int updateMember(Member member);
}
