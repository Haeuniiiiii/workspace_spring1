package kr.or.ddit.controller.book;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.service.IBookService;

// Book 수정 페이지와 수정 기능
@Controller
@RequestMapping("/book")
public class BookModifyController {
	
	@Autowired
	private IBookService bookService;
	
	// Book 게시판 수정 페이지
	@GetMapping("/update.do")
	public ModelAndView updateBookForm(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> detailMap = bookService.selectBook(map); 
		// book이라는 키를 들고 Id와 일치하는 책정보 담고 있는 detailMap
		mav.addObject("book", detailMap);
		mav.setViewName("book/update");
		return mav;
	}
	
	// BOOK 게시판 수정 기능
	@PostMapping("/update.do")
	public ModelAndView updateBook(@RequestParam Map<String, Object> map) {
		/*
		 * {
		 * 		"bookId" : 2
		 * 		"title" : "제목수정"
		 * 		"category" : "내용수정"
		 * 		"price" : 14000
		 */
		ModelAndView mav = new ModelAndView();
		
		boolean isUpdateSuccess = bookService.updateBook(map);
		if(isUpdateSuccess) {	// 수정 성공
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/book/detail.do?bookId=" + bookId);
		} else {	// 수정 실패
			// 갱신이 되지 않았을 경우, GET 메소드로 redirect 하는 방법도 있지만,
			// 상세보기 화면을 바로 보여줄 수도 있습니다.
			mav = updateBookForm(map);
		}
		return mav;
	}
	
	
	// BOOK 게시판 삭제 기능
	@PostMapping("/delete.do")
	public ModelAndView deleteBook(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		boolean isDeleteSuccess = bookService.deleteBook(map);
		if(isDeleteSuccess) {	// 삭제 성공
			mav.setViewName("redirect:/book/list.do");
		} else { // 삭제 실패
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/book/detail.do?bookId=" + bookId);
		}
		
		return mav;
	}
}
