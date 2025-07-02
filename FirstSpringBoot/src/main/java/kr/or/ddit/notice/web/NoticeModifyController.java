package kr.or.ddit.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.vo.NoticeVO;

// 수정페이지, 수정기능, 삭제 기능을 처리할 컨트롤러
@Controller
@RequestMapping("/notice")
public class NoticeModifyController {
	
	@Autowired
	private INoticeService noticeService;
	
	// 수정 페이지
	@GetMapping("/update.do")
	public String noticeUpdateForm(int noticeNo, Model model) {
		NoticeVO noticeVO = noticeService.selectNotice(noticeNo);
		model.addAttribute("notice", noticeVO);
		model.addAttribute("status", "u");
		return "notice/form";
	}
	
	
	// 수정 기능
	@PostMapping("/update.do")
	public String noticeUpdate(NoticeVO noticeVO, Model model) {
		String goPage = "";
		ServiceResult result = noticeService.updateNotice(noticeVO);
		if(result.equals(ServiceResult.OK)) {	// 수정 성공
			goPage = "redirect:/notice/detail.do?noticeNo=" + noticeVO.getNoticeNo();
		} else {	// 수정 실패
			model.addAttribute("notice", noticeVO);
			model.addAttribute("status", "u");
			goPage = "notice/form";
		}
		return goPage;
	}
	
}
