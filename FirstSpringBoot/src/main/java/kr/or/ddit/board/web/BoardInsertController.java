package kr.or.ddit.board.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardInsertController {
	
	@Autowired
	private IBoardService boardService;

	// 일반게시판 등록 페이지
	@GetMapping("/form.do")
	public String boardForm() {
		return"board/form";
	}
	
	
	// form 태그를 통해 전달받은 데이터 처리
	@PostMapping("/insert.do")
	public String boardInsert(BoardVO boardVO, Model model) {
		
		String goPage = "";	// 이동할 페이지 정보
		// 클라이언트에서 전달받은 데이터가 혹시나 에러가 발생했을 때 에러정보를 담을 공간
		Map<String, String> errors = new HashMap<>();
		
		// 전달받은 제목 데이터가 잘못됐을 때 (기본 유효성 검사를 진행 시, 누락되었을 때)
		if(StringUtils.isBlank(boardVO.getBoTitle())) {
			errors.put("boTitle", "제목을 입력해주세요!");
		}
		
		// 전달받은 내용 데이터가 잘못됐을 때 (기본 유효성 검사를 진행 시, 누락되었을 때)
		if(StringUtils.isBlank(boardVO.getBoContent())) {
			errors.put("boContent", "내용을 입력해주세요!");
		}
		
		// 전달이 잘 되었을 때, 유효성검사 모두 통과했을 때 이쪽을 거쳐가기
		if(errors.size() > 0) {	// 에러발생
			model.addAttribute("errors", errors);
			model.addAttribute("board", boardVO);
			goPage = "board/form"; // 포워딩 진행
		} else {	// 정상적인 데이터
			// 로그인 처리가 되지 않았으므로 아이디 임의로 a001 작성
			boardVO.setBoWriter("a001");
			ServiceResult result = boardService.insertBoard(boardVO);	// 게시글 등록
			
			if( result.equals(ServiceResult.OK) ) { // 등록 성공
				goPage = "redirect:/board/detail.do?boNo="+boardVO.getBoNo();
			} else { // 등록 실패
				goPage = "board/form";
			}
		}
		
		return goPage;
		
	}
}
