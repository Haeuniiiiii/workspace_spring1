package kr.or.ddit.free.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/free")
public class FreeInsertController {

	// 자유게시판 등록 페이지
	@GetMapping("/form.do")
	public String freeForm() {
		return"free/form";
	}
	
}
