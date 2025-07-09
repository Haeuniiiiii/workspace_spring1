package kr.or.ddit.mapper;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardMapper {
	
	public List<BoardVO> selectBoardList();
	
	public int registBoard(BoardVO boardVO);

	public BoardVO selectBoardDetail(String boardNo);

	public void addBoardHit(String boardNo);
	
	public int deleteBoard(BoardVO boardVO);
	
	public int updateBoard(BoardVO boardVO);
	
}
