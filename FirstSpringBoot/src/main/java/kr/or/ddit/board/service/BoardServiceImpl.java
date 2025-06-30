package kr.or.ddit.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.board.mapper.IBoardMapper;
import kr.or.ddit.vo.BoardVO;

@Service
public class BoardServiceImpl implements IBoardService {

	@Autowired
	private IBoardMapper mapper;
	
	@Override
	public ServiceResult insertBoard(BoardVO boardVO) {
		ServiceResult result = null;
		
		// 등록했다면 1 실패했다면 0 을 받았겠죠
		int status = mapper.insertBoard(boardVO);
		if(status > 0) {	// 등록 성공
			result = ServiceResult.OK;
		} else {	// 등록 실패
			result = ServiceResult.FAILED;
		}
			
		return result;
	}

	
	@Override
	public BoardVO selectBoard(int boNo) {
		mapper.incrementHit(boNo);	// 조회수 증가
		return mapper.selectBoard(boNo);
	}

}
