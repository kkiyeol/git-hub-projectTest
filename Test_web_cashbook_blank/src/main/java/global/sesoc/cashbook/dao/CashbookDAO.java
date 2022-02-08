package global.sesoc.cashbook.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.cashbook.vo.CashbookVO;

@Repository
public class CashbookDAO {

	@Autowired
	SqlSession sqlsession;
	
}
