package kr.or.ddit.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.main.mapper.IMainMapper;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Service
public class MainServiceImpl implements IMainService {
	
    @Autowired
    private IMainMapper mainMapper;

    @Override
    public int selectFreeCount(PaginationInfoVO<FreeVO> pagingVO) {
        return mainMapper.selectFreeCount(pagingVO);
    }

    @Override
    public List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pagingVO) {
        return mainMapper.selectFreeList(pagingVO);
    }

	@Override
	public int selectBoardCount(PaginationInfoVO<BoardVO> pagingBoardVO) {
		return mainMapper.selectBoardCount(pagingBoardVO);
	}

	@Override
	public List<BoardVO> selectBoardList(PaginationInfoVO<BoardVO> pagingBoardVO) {
		return mainMapper.selectBoardList(pagingBoardVO);
	}
	
	

}
