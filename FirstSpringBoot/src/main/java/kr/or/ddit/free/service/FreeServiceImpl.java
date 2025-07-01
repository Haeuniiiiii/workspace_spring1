package kr.or.ddit.free.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.free.mapper.IFreeMapper;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Service
public class FreeServiceImpl implements IFreeService {

	@Autowired
	private IFreeMapper mapper;

	@Override
	public ServiceResult insertFree(FreeVO freeVO) {
		
		ServiceResult result = null;
		
		// 등록했다면 1 실패했다면 0을 받았죠!
		int status = mapper.insertFree(freeVO);
		if(status > 0) {
			result = ServiceResult.OK; // 등록 성공
		} else {
			result = ServiceResult.FAILED; // 등록 실패
		}
		return result;
	}

	
	@Override
	public FreeVO selectFree(int freeNo) {
		mapper.incrementHit(freeNo);	// 선택 시 조회수 증가
		return mapper.selectFree(freeNo);
	}


	@Override
	public int selectFreeCount(PaginationInfoVO<FreeVO> pVO) {
		return mapper.selectFreeCount(pVO);
	}


	@Override
	public List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pVO) {
		return mapper.selectFreeList(pVO);
	}

	
	
	
	
}
