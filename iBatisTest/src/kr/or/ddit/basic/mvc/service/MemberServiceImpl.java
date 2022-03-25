package kr.or.ddit.basic.mvc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.basic.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtill3;
import kr.or.ddit.basic.mvc.dao.IMemberDao;
import kr.or.ddit.basic.mvc.dao.MemberDaoImpl;

public class MemberServiceImpl implements IMemberService {
	private static MemberServiceImpl memservice;
	private IMemberDao dao;
	//생성자
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance() {
		if(memservice == null) memservice = new MemberServiceImpl();
		
		return memservice;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		// TODO Auto-generated method stub
		return 0;
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

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
