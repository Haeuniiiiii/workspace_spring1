package kr.or.ddit.free.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/free")
public class FreeRetrieveController {

	// 자유게시판 목록 페이지
	@GetMapping("/list.do")
	public String freeList() {
		return "free/list";
	}
	
	// 자유게시판 상세정보 페이지
	@GetMapping("/detail.do")
	public String freeDetail() {
		return "free/view";
	}
	
}
