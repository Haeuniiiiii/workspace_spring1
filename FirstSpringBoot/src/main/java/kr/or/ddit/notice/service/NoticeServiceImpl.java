package kr.or.ddit.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.notice.mapper.INoticeMapper;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Service
public class NoticeServiceImpl implements INoticeService {

	@Autowired
	private INoticeMapper mapper;
	
	@Override
	public ServiceResult insertNotice(NoticeVO NoticeVO) {
		ServiceResult result = null;
		
		// 등록했다면 1 실패했다면 0 을 받았겠죠
		int status = mapper.insertNotice(NoticeVO);
		if(status > 0) {	// 등록 성공
			result = ServiceResult.OK;
		} else {	// 등록 실패
			result = ServiceResult.FAILED;
		}
			
		return result;
	}

	
	@Override
	public NoticeVO selectNotice(int noNo) {
		mapper.incrementHit(noNo);	// 조회수 증가
		return mapper.selectNotice(noNo);
	}


	@Override
	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO) {
		return mapper.selectNoticeCount(pagingVO);
	}


	@Override
	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO) {
		return mapper.selectNoticeList(pagingVO);
	}


	@Override
	public ServiceResult updateNotice(NoticeVO NoticeVO) {
		ServiceResult result = null;
		int status = mapper.updateNotice(NoticeVO);
		if(status > 0) {	// 수정 성공
			result = ServiceResult.OK;
		} else {	// 수정 실패
			result = ServiceResult.FAILED;
		}
		return result;
	}


	@Override
	public ServiceResult deleteNotice(int noNo) {
		ServiceResult result = null;
		int status = mapper.deleteNotice(noNo);
		if(status > 0) {	// 삭제 성공
			result = ServiceResult.OK;
		} else {	// 삭제 실패
			result = ServiceResult.FAILED;
		}
		return result;
	}
	
}
