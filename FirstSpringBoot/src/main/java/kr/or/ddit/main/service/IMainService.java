package kr.or.ddit.main.service;

import java.util.List;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface IMainService {

	int selectFreeCount(PaginationInfoVO<FreeVO> pagingVO);

	List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pagingVO);

	int selectBoardCount(PaginationInfoVO<BoardVO> pagingBoardVO);

	List<BoardVO> selectBoardList(PaginationInfoVO<BoardVO> pagingBoardVO);



}
