package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class BoardServiceImpl implements IBoardService{
	private static BoardServiceImpl service;
	private IBoardDao dao;
	//생성자
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	public static BoardServiceImpl getInstance() {
		if(service == null) service = new BoardServiceImpl();
		
		return service;
	}
	@Override
	public int insertBoard(BoardVO jBoardVo) {
		SqlMapClient smc = null;
		int cnt = 0;
		try {
			smc = SqlMapClientFactory.getClientFactory();
			cnt = dao.insertBoard(smc, jBoardVo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}
	@Override
	public int deleteBoard(int boardNo) {
		SqlMapClient smc = null;
		int cnt = 0;
		try {
			smc = SqlMapClientFactory.getClientFactory();
			cnt = dao.deleteBoard(smc, boardNo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}
	@Override
	public int updateBoard(BoardVO jBoardVo) {
		SqlMapClient smc = null;
		int cnt = 0;
		try {
			smc = SqlMapClientFactory.getClientFactory();
			cnt = dao.updateBoard(smc, jBoardVo);
		} catch (SQLException e) {
			cnt = 0 ;
			e.printStackTrace();
		}
		
		return cnt;
	}
	@Override
	public BoardVO getBoard(int boardNo) {
		SqlMapClient smc = null;
		BoardVO vo = null;
		try {
			
			smc = SqlMapClientFactory.getClientFactory();
			
			//조회수 증가
			int cnt = service.setCountIncrement(boardNo); 
			if(cnt==0) {
				return null;
			}
			vo = dao.getBoard(smc, boardNo);
		} catch (SQLException e) {
			vo = null;
		}
		return vo;
	}
	@Override
	public List<BoardVO> getSearchBoardList(String jBoardTitle) {
		SqlMapClient smc = null;
		List<BoardVO> boardList = null;
		try {
			smc = SqlMapClientFactory.getClientFactory();
			boardList = dao.getSearchBoardList(smc, jBoardTitle);
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}
	@Override
	public List<BoardVO> getAllBoards() {
		SqlMapClient smc = null;
		List<BoardVO> boardList = null;
		
		try {
			smc = SqlMapClientFactory.getClientFactory();
			boardList = dao.getAllBoards(smc);
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		
		return boardList;
	}
	@Override
	public int setCountIncrement(int boardNo) {
		SqlMapClient smc = null;
		int cnt = 0;
		try {
			smc = SqlMapClientFactory.getClientFactory();
			cnt = dao.setCountIncrement(smc, boardNo);
		
		} catch (SQLException e) {
			cnt = 0 ;
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	
}
