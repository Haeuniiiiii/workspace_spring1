package kr.or.ddit.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.BoardVO;

@Mapper
public interface IBoardMapper {

	public int insertBoard(BoardVO boardVO);

	public void incrementHit(int boNo);
	
	public BoardVO selectBoard(int boNo);

}
