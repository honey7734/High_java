package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;

public class BoardDaoImpl implements IBoardDao {
	//싱글톤
	private static BoardDaoImpl dao;
	private BoardDaoImpl() {}
	public static BoardDaoImpl getInstance() {
		if(dao == null) dao = new BoardDaoImpl();
		return dao;
	}

	@Override
	public int insertBoard(SqlMapClient smc, BoardVO jBoardVo) throws SQLException {
		Object obj = smc.insert("board.insertBoard",jBoardVo);
		
		if(obj == null) return 1;
		
		return 0;
	}

	@Override
	public int deleteBoard(SqlMapClient smc, int boardNo) throws SQLException {
		return smc.delete("board.deleteBoard", boardNo);
	}
	
	@Override
	public int updateBoard(SqlMapClient smc, BoardVO jBoardVo) throws SQLException {
		return smc.update("board.updateBoard", jBoardVo);
	}

	@Override
	public BoardVO getBoard(SqlMapClient smc, int boardNo) throws SQLException {
		return (BoardVO) smc.queryForObject("board.getBoard", boardNo);
	}

	@Override
	public List<BoardVO> getSearchBoardList(SqlMapClient smc, String jBoardTitle) throws SQLException {
		return smc.queryForList("board.getSearchBoardList", jBoardTitle);
	}

	@Override
	public List<BoardVO> getAllBoards(SqlMapClient smc) throws SQLException {
		return smc.queryForList("board.getAllBoard");
	}
	
	@Override
	public int setCountIncrement(SqlMapClient smc, int boardNo) throws SQLException {
		return smc.update("board.setCountIncrement", boardNo);
	}

}
