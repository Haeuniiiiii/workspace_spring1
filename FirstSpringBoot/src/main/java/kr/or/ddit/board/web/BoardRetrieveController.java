package kr.or.ddit.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardRetrieveController {
	
	// 서비스에 대한 DI
	@Autowired
	private IBoardService boardService;
	
	// 일반게시판 목록 페이지
	@GetMapping("/list.do")
	public String boardList() {
		return "board/list";
	}
	
	// 일반게시판 상세정보 페이지
	@GetMapping("/detail.do")
	public String boardDetail(int boNo, Model model) {
		
		BoardVO boardVO = boardService.selectBoard(boNo);
		model.addAttribute("board", boardVO);
		
		return "board/view";
	}
	
	
}
