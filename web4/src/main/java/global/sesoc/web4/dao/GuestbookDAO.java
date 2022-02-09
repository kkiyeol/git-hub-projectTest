package global.sesoc.web4.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.web4.vo.Guestbook;

@Repository
public class GuestbookDAO {

	@Autowired
	SqlSession sqlSession;
	
	public int insert(Guestbook board) {
		GuestbookMapper mapper = sqlSession.getMapper(GuestbookMapper.class);
		int res = mapper.insert(board);
		return res;
	}

	public ArrayList<Guestbook> select() {
		GuestbookMapper mapper = sqlSession.getMapper(GuestbookMapper.class);
		ArrayList<Guestbook> res = mapper.select();
		return res;
	}

	public int delete(int num, String password2) {
		GuestbookMapper mapper = sqlSession.getMapper(GuestbookMapper.class);
		int res = mapper.delete(num, password2);
		return res;
		
	}

	public int selectMax() {
		GuestbookMapper mapper = sqlSession.getMapper(GuestbookMapper.class);
		int res = mapper.selectMax();
		return res;
	}
	
}
