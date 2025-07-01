package kr.or.ddit.vo;

import lombok.Data;

@Data
public class NoticeVO {

	private int noNo;			// 공지사항 번호
	private String noTitle;		// 공지사항 제목
	private String noWriter;	// 공지사항 작성자
	private String noContent;	// 공지사항 내용
	private String noDate;		// 공지사항 작성일
	private int noHit;			// 공지사항 조회수
	
}
