package kr.or.ddit.free.service;

import java.util.List;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface IFreeService {
	
	public ServiceResult insertFree(FreeVO freeVO);

	public FreeVO selectFree(int freeNo);

	public int selectFreeCount(PaginationInfoVO<FreeVO> pVO);

	public List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pVO);

	public ServiceResult updateFree(FreeVO freeVO);

	public ServiceResult deleteFree(int freeNo);
	
	
	// 필요한 필드값 VO 클래스 생성
	// 등록버튼 누르면 등록 폼페이지 링크 나오게
	// insert 등록
	// 제목이랑 내용에 대한 데이터 넘겨주기 -> DB
	// 맵퍼를 통해서 쿼리문작성하기(insert)
	// 등록 이후 페이지가 detail 페이지로 넘어가게(freeNo 값을 기반으로)
	
}
