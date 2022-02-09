package global.sesoc.web99.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.web99.vo.Board;

@Repository
public class BoardDAO {
	@Autowired
	SqlSession sqlSession;

	public int insertBoard(Board board) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int result = mapper.insertBoard(board);
		return result;
	}

	public ArrayList<Board> list() {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<Board> result = mapper.listBoard();
		return result;
	}

	public Board read(int num) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		Board result = mapper.getBoard(num);
		return result;
	}

	public int updateBoard(Board board) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int result = mapper.updateBoard(board);
		return result;
	}

	public int deleteBoard(Board board) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int result = mapper.deleteBoard(board);
		return result;
	}
	
	
}
