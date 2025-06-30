package kr.or.ddit.vo;

import java.util.List;

import lombok.Data;

@Data
public class PaginationInfoVO<T> {

	private int totalRecord;	// 총 게시글 수
	private int totalPage; 		// 총 페이지 수
	private int currentpage;	// 현재 페이지
	private int screenSize;		// 페이지 당 게시글 수
	private int blockSize;		// 페이지 블록 수
	private int startRow;		// 시작 row
	private int endRow;			// 끝 row
	private int startPage;		// 시작 Page
	private int endPage;		// 끝 page
	private List<T> dataList;	// 결과를 넣을 데이터 리스트
	private String searchType;	// 검색 타입
	private String searchWord;	// 검색 단어
	
	public PaginationInfoVO() {}
	
	// PaginationInfoVO 객체를 만들 때, 한 페이지 당 게시글 수 와 페이지 블록 수를 원하는 값으로 초기화 할 수 있다.
	public PaginationInfoVO(int screenSize, int blockSize) {
		this.screenSize = screenSize;
		this.blockSize = blockSize;
	}
	
	
}
