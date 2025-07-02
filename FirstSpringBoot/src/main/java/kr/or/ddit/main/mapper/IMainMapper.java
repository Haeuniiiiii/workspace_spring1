package kr.or.ddit.main.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Mapper
public interface IMainMapper {
	
    int selectFreeCount(PaginationInfoVO<FreeVO> pagingVO);
    
    List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pagingVO);

	int selectBoardCount(PaginationInfoVO<BoardVO> pagingBoardVO);

	List<BoardVO> selectBoardList(PaginationInfoVO<BoardVO> pagingBoardVO);
    
}

