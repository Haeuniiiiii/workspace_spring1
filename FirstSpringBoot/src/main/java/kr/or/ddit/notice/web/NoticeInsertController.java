package kr.or.ddit.notice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeInsertController {

	// 공지사항 등록 페이지
	@GetMapping("/form.do")
	public String noticeForm() {
		return"notice/form";
	}
	
}
