package global.sesoc.cashbook.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.cashbook.vo.CashbookVO;
import global.sesoc.cashbook.vo.MemberVO;
import global.sesoc.cashbook.vo.TotalVO;

@Repository
public class CashbookDAO {

	@Autowired
	SqlSession sqlSession;
	
	/**
	 * 가계부 내역 저장
	 * @param vo 사용자가 입력한 가계부 내역
	 * @return 저장된 행 개수
	 */
	public int insert(CashbookVO vo) {
		CashbookMapper mapper = sqlSession.getMapper(CashbookMapper.class);
		int result = mapper.insert(vo);
		return result;
	}
	
	/**
	 * 가계부 내역 삭제
	 * @param infonum 삭제할 내역정보 번호
	 * @return 삭제된 행 개수
	 */
	public int delete(CashbookVO vo) {
		CashbookMapper mapper = sqlSession.getMapper(CashbookMapper.class);
		int result = mapper.delete(vo);
		return result;
	}
	
	/**
	 * 전체 내역
	 * @param id 로그인한 사용자 아이디
	 * @return 결과를 담은 ArrayList 객체
	 */
	public ArrayList<CashbookVO> select(String id) {
		CashbookMapper mapper = sqlSession.getMapper(CashbookMapper.class);
		ArrayList<CashbookVO> list = mapper.select(id);
		return list;
	}

	/**
	 * 연도별 통계
	 * @param id 로그인한 사용자 아이디
	 * @return
	 */
	public ArrayList<TotalVO> total(String id) {
		CashbookMapper mapper = sqlSession.getMapper(CashbookMapper.class);
		ArrayList<TotalVO> list = mapper.total(id);
		return list;
	}

}