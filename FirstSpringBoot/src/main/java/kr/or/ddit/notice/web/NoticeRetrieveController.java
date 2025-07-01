package kr.or.ddit.notice.web;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Controller
@RequestMapping("/notice")
public class NoticeRetrieveController {
	
	// 서비스에 대한 DI
	@Autowired
	private INoticeService noticeService;
	
	// 일반게시판 목록 페이지
	@RequestMapping("/list.do")
	public String NoticeList(@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage
							,@RequestParam(required = false, defaultValue="title") String searchType
							,@RequestParam(required = false) String searchWord
							,Model model) {
		
		PaginationInfoVO<NoticeVO> pagingVO = new PaginationInfoVO<>();
		
		// 브라우저에서 검색한 검색유형, 검색키워드를 이용하여 검색 처리
		// 검색 키워드가 있으면 검색읠 한거고, 키워드가 없으면 검색을 하지 않음
		if( StringUtils.isNotBlank(searchWord)) {
			pagingVO.setSearchType(searchType);
			pagingVO.setSearchWord(searchWord);
			model.addAttribute("searchType", searchType);
			model.addAttribute("searchWord", searchWord);
		}
		
		
		// startRow endRow startPage endPage 가 결정된다.
		pagingVO.setCurrentPage(currentPage);
		
		// 총 게시글 수 가져오기
		int totalRecord = noticeService.selectNoticeCount(pagingVO);
		// totalPage가 결정된다.
		pagingVO.setTotalRecord(totalRecord);
		
		// startRow endRow 영역에 해당하는 게시글 목록 조회
		List<NoticeVO> dataList = noticeService.selectNoticeList(pagingVO);
		pagingVO.setDataList(dataList);
		
		model.addAttribute("pagingVO", pagingVO);
		
		return "notice/list";
	}
	
	// 일반게시판 상세정보 페이지
	@GetMapping("/detail.do")
	public String noticeDetail(int noNo, Model model) {
		NoticeVO noticeVO = noticeService.selectNotice(noNo);
		model.addAttribute("notice", noticeVO);
		
		return "notice/view";
	}
	
	
	@PostMapping("/delete.do")
	public String noticeDelete(int noNo, Model model) {
		String goPage = "";
		ServiceResult result = noticeService.deleteNotice(noNo);
		if(result.equals(ServiceResult.OK)) {	// 삭제 성공
			goPage = "redirect:/notice/list.do";
		} else {	// 삭제 실패
			goPage = "redirect:/notice/detail.do?noNo=" + noNo;
		}
		return goPage;
	}
	
	
}
