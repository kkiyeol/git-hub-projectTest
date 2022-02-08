package global.sesoc.cashbook.dao;

import java.util.ArrayList;

import global.sesoc.cashbook.vo.CashbookVO;
import global.sesoc.cashbook.vo.TotalVO;

//가계부 내역 처리
public interface CashbookMapper {
	//저장
	public int insert(CashbookVO vo);
	//삭제
	public int delete(CashbookVO vo);
	//전체 목록
	public ArrayList<CashbookVO> select(String id);
	//연도별 통계
	public ArrayList<TotalVO> total(String id);
}
