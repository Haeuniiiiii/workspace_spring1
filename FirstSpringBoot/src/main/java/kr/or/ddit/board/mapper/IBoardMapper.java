package kr.or.ddit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Mapper
public interface IBoardMapper {

	public int insertBoard(BoardVO boardVO);
	public void incrementHit(int boNo);
	public BoardVO selectBoard(int boNo);

	public int selectBoardCount(PaginationInfoVO<BoardVO> pagingVO);
	public List<BoardVO> selectBoardList(PaginationInfoVO<BoardVO> pagingVO);
	public int updateBoard(BoardVO boardVO);
	public int deleteBoard(int boNo);

}
