package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.board.vo.BoardVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public interface IBoardDao {
	
	public int insertBoard(SqlMapClient smc, BoardVO jBoardVo) throws SQLException;
	
	public int deleteBoard(SqlMapClient smc, int boardNo) throws SQLException;

	public int updateBoard(SqlMapClient smc, BoardVO jBoardVo) throws SQLException;
	
	public BoardVO getBoard(SqlMapClient smc, int boardNo) throws SQLException;
	
	public List<BoardVO> getSearchBoardList(SqlMapClient smc, String jBoardTitle) throws SQLException;
	
	public List<BoardVO> getAllBoards(SqlMapClient smc) throws SQLException;
	
	public int setCountIncrement(SqlMapClient smc, int boardNo) throws SQLException; 
}
