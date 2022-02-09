package global.sesoc.web99.dao;

import java.util.ArrayList;

import global.sesoc.web99.vo.Board;

public interface BoardMapper {

	public int insertBoard(Board board);

	public ArrayList<Board> listBoard();

	public Board getBoard(int num);

	public int updateBoard(Board board);

	public int deleteBoard(Board board);

	
}
