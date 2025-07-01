package kr.or.ddit.vo;

import lombok.Data;
import lombok.Getter;

@Data
public class FreeVO {
	
	private int freeNo;				// 자유게시판 번호
	private String freeTitle;		// 자유게시판 제목
	private String freeWriter;		// 자유게시판 작성자
	private String freeContent;		// 자유게시판 내용
	private String freeDate;		// 자유게시판 작성일
	private int freeHit;			// 자유게시판 조회수

}
