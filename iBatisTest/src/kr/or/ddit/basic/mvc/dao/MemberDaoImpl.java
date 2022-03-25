package kr.or.ddit.basic.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.basic.mvc.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {
	
	private static MemberDaoImpl memDao;
	
	private MemberDaoImpl() {}
	
	public static MemberDaoImpl getInstance() {
		if(memDao == null) memDao = new MemberDaoImpl();
		
		return memDao;
	}

	@Override
	public int insertMember(SqlMapClient smc, MemberVO memVo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(SqlMapClient smc, String memId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(SqlMapClient smc, MemberVO memVo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberVO> getAllMember(SqlMapClient smc) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMemberCount(Connection conn, String memId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember2(Connection conn, Map<String, String> paramMap) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
