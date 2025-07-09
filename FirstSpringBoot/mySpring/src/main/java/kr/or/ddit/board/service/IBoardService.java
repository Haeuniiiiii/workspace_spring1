package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardService {

	public List<BoardVO> selectBoardList();

	public int registBoard(BoardVO boardVO);

	public BoardVO selectBoardDetail(String boardNo);

	public int deleteBoard(BoardVO boardVO);

	public int updateBoard(BoardVO boardVO);

}
