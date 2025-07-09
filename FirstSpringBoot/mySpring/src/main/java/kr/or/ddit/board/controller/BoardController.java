package kr.or.ddit.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private IBoardService boardService;
	
	@RequestMapping(value ="/list.do", method = RequestMethod.GET)
	public String selectBoardList(Model model) {
		
		List<BoardVO> boardList = boardService.selectBoardList();
		model.addAttribute("boardList", boardList);
		
		return "/board/list";
	}
	
	@RequestMapping(value = "/regist.do", method = RequestMethod.GET)
	public String registBoard() {
		return "board/registForm";
	}
	
//	ResponseEntity<String>
//	ResponseEntity는 HTTP 응답 자체를 커스터마이징할 수 있게 해주는 객체
//	여기선 제네릭 타입으로 String을 사용했으니, 본문(body)으로 문자열("SUCCESS" 또는 "FAIL")을 반환하게 됨.
//	추가로 **HTTP 상태 코드(HttpStatus)**도 함께 담아서 클라이언트에게 전달할 수 있음.
//  @ResponseBody가 있으면, return 값은 뷰 이름이 아니라 → 데이터를 클라이언트에게 "그대로" 응답	
	
	@ResponseBody
	@RequestMapping(value = "regist.do", method = RequestMethod.POST)
												  // json 형식일때는 @RequestBody붙이기
	public ResponseEntity<String> registBoardAjax(@RequestBody BoardVO boardVO){
		
		ResponseEntity<String> result = null;
		log.info("### boardVO ::: {}" , boardVO);
		
		int cnt = boardService.registBoard(boardVO);
		
		if(cnt > 0 ) {				// 제너릭 안의 타입값과 일치 
			result = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} else {
			result = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}
		
		return result;
	}
	@RequestMapping(value ="/detail.do", method = RequestMethod.GET)
	public String selectBoardDetail(Model model, String boardNo) {
		
		log.info("boardNo ::: {}", boardNo);
		
		BoardVO boardDetailVO = boardService.selectBoardDetail(boardNo);
		
		model.addAttribute("boardVO", boardDetailVO);
		
		return "board/detail";
	}
	
	@ResponseBody
	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
													// json 형식일때는 @RequestBody붙이기
	public ResponseEntity<String> deleteBoardAjax(@RequestBody BoardVO boardVO){
			
		ResponseEntity<String> result = null;
		log.info("### boardVO ::: {}" , boardVO);
		
		int cnt = boardService.deleteBoard(boardVO);
		
		if(cnt > 0 ) {				// 제너릭 안의 타입값과 일치 
			result = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} else {
			result = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}
		
		return result;
	}
	
	// 자바 
	// 직렬화    : 자바 객체 → 데이터 형태 (JSON, 바이너리 등)로 바꾸는 것 
	// 역직렬화 : 데이터 형태 (JSON, XML 등) → 자바 객체로 바꾸는 것
	
//	| 용어                | 의미                       |  자바 스크립트      |
//	| --------  | ------------------------  |
//	| **직렬화**  | JS 객체 → 문자열(JSON 형식)로 변환  |
//	| **역직렬화** | JSON 문자열 → JS 객체로 변환            |
											
	@ResponseBody
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
													// json 형식일때는 @RequestBody붙이기
	public ResponseEntity<BoardVO> updateBoardAjax(@RequestBody BoardVO boardVO){
		
		ResponseEntity<BoardVO> result = null;
		log.info("### boardVO ::: {}" , boardVO);
		
		BoardVO updateBoardVO = null;
		
		int cnt = boardService.updateBoard(boardVO);
		
		if(cnt > 0 ) {
			updateBoardVO = boardService.selectBoardDetail(boardVO.getBoardNo());
			result = new ResponseEntity<BoardVO>(updateBoardVO, HttpStatus.OK);
		} 
		return result;
	}
}

