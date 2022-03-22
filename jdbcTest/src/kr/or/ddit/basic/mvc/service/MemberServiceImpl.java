package kr.or.ddit.basic.mvc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.basic.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtill3;
import kr.or.ddit.basic.mvc.dao.IMemberDao;
import kr.or.ddit.basic.mvc.dao.MemberDaoImpl;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao;
	//생성자
	public MemberServiceImpl() {
		dao = new MemberDaoImpl();
	}
	
	@Override
	public int insertMember(MemberVO memVo) {
		Connection conn = null;
		int cnt = 0;
		try {
			conn = DBUtill3.getConnection();
			cnt = dao.insertMember(conn, memVo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberVO> getAllMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMemberCount(String memId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
