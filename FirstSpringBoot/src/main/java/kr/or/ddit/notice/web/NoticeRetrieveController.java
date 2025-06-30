package kr.or.ddit.notice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeRetrieveController {

	// 공지사항 목록 페이지
	@GetMapping("/list.do")
	public String noticeList() {
		return "notice/list";
	}
	
	// 공지사항 상세정보 페이지
	@GetMapping("/detail.do")
	public String noticeDetail() {
		return "notice/view";
	}
	
}
