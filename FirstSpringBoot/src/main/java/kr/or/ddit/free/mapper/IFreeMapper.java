package kr.or.ddit.free.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Mapper
public interface IFreeMapper {
	
	public int insertFree(FreeVO freeVO);
	public void incrementHit(int freeNo);
	public FreeVO selectFree(int freeNo);

	
	public int selectFreeCount(PaginationInfoVO<FreeVO> pVO);
	public List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pVO);

}
