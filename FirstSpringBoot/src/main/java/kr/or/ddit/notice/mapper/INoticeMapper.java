package kr.or.ddit.notice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Mapper
public interface INoticeMapper {

	public int insertNotice(NoticeVO NoticeVO);
	public void incrementHit(int noNo);
	public NoticeVO selectNotice(int noNo);

	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO);
	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO);
	public int updateNotice(NoticeVO NoticeVO);
	public int deleteNotice(int noNo);

}
