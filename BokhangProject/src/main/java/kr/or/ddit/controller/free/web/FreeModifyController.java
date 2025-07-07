//package kr.or.ddit.controller.free.web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import kr.or.ddit.ServiceResult;
//import kr.or.ddit.board.service.IBoardService;
//import kr.or.ddit.vo.BoardVO;
//
//// 수정페이지, 수정기능, 삭제 기능을 처리할 컨트롤러
//@Controller
//@RequestMapping("/board")
//public class FreeModifyController {
//	
//	@Autowired
//	private IBoardService boardService;
//	
//	// 수정 페이지
//	@GetMapping("/update.do")
//	public String boardUpdateForm(int boNo, Model model) {
//		BoardVO boardVO = boardService.selectBoard(boNo);
//		model.addAttribute("board", boardVO);
//		model.addAttribute("status", "u");
//		return "board/form";
//	}
//	
//	
//	// 수정 기능
//	@PostMapping("/update.do")
//	public String boardUpdate(BoardVO boardVO, Model model) {
//		String goPage = "";
//		ServiceResult result = boardService.updateBoard(boardVO);
//		if(result.equals(ServiceResult.OK)) {	// 수정 성공
//			goPage = "redirect:/board/detail.do?boNo=" + boardVO.getBoNo();
//		} else {	// 수정 실패
//			model.addAttribute("board", boardVO);
//			model.addAttribute("status", "u");
//			goPage = "board/form";
//		}
//		return goPage;
//	}
//	
//}
