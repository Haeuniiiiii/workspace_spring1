package kr.or.ddit.vo;

import lombok.Data;

@Data
public class NoticeVO {

	private int noticeNo;			// 공지사항 번호
	private String noticeTitle;		// 공지사항 제목
	private String noticeWriter;	// 공지사항 작성자
	private String noticeContent;	// 공지사항 내용
	private String noticeDate;		// 공지사항 작성일
	private int noticeHit;			// 공지사항 조회수
	
}
