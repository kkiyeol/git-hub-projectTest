package global.sesoc.web4.dao;

import java.util.ArrayList;

import global.sesoc.web4.vo.Guestbook;

public interface GuestbookMapper {

	public int insert(Guestbook board);

	public ArrayList<Guestbook> select();

	public int delete(int num, String password2);

	public int selectMax();
}
