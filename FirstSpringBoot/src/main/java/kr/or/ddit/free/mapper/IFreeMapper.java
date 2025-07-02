package kr.or.ddit.free.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Mapper
public interface IFreeMapper {
	
	// 등록이 됐는지 확인 ( 0 | 1 )
	public int insertFree(FreeVO freeVO);
	// 게시글 조회수 증가 (int)
	public void incrementHit(int freeNo);
	// 선택한 게시글 조회 (키인 No 값으로)
	public FreeVO selectFree(int freeNo);
	// 결과를 담은 데이터VO (페이지처리를 위함)
	public int selectFreeCount(PaginationInfoVO<FreeVO> pVO);
	// 결과를 담은 리스트타입의 VO (페이징처리를 위함)
	public List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pVO);
	// 수정 성공 실패!? 성공했다면 성공한 데이터 담아 보내기
	public int updateFree(FreeVO freeVO);
	// 삭제 성공 실패? (0 1) 삭제할 no 키값을 찾아서 삭제 시키기
	public int deleteFree(int freeNo);

}
