package kr.or.ddit.board.vo;

import lombok.Data;

@Data
public class BoardVO {
	
	private String rno;
	
	private String boardNo;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private int boardHit;
	private String boardDelyn;
	private String regDt;
	private String updDt;
	
}
