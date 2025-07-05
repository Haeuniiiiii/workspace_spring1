package kr.or.ddit.free.web;

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
import kr.or.ddit.free.service.IFreeService;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j // simple log4j
@Controller
@RequestMapping("/free")
public class FreeRetrieveController {

	// 서비스에 대한 DI
	@Autowired
	private IFreeService freeService;

	// 자유게시판 목록 페이지
	@RequestMapping("/list.do")
	public String freeList(@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage
						  ,@RequestParam(required = false, defaultValue = "title") String searchType
						  ,@RequestParam(required = false) String searchWord
						  ,Model model) {
		
		PaginationInfoVO<FreeVO> pVO = new PaginationInfoVO<>();
		
		// 브라우저에서 검색한 검색유형, 검색키워드를 이용하여 검색 처리
		// 검색 키워드가 있으면 검색을 한거고, 키워드가 없으면 검색을 하지 않음
		if ( StringUtils.isNoneBlank(searchWord) ) {
			pVO.setSearchType(searchType);
			pVO.setSearchWord(searchWord);
			model.addAttribute("searchType", searchType);
			model.addAttribute("searchWord", searchWord);
		}
		pVO.setCurrentPage(currentPage);
		
		// 총 게시글 수 가져오기 
		int totalRecord = freeService.selectFreeCount(pVO);
		pVO.setTotalRecord(totalRecord);
		
		List<FreeVO> dataList = freeService.selectFreeList(pVO);
		pVO.setDataList(dataList);
		
		model.addAttribute("pagingVO", pVO);
		
		return "free/list";
	}
	
	// 자유게시판 상세정보 페이지
	@GetMapping("/detail.do")
	public String freeDetail(int freeNo, Model model) {
//		freeService.incrementHit();
		FreeVO freeVO = freeService.selectFree(freeNo);
		model.addAttribute("free", freeVO);
		
		return "free/view";
	}
	
	@PostMapping("/delete.do") // 목적지 설정과 get Post 중요.......
	public String freeDelete(int freeNo, Model model) {
		String goPage = "";
		ServiceResult result = freeService.deleteFree(freeNo);
		
//		log.debug();
		if(result.equals(ServiceResult.OK)) {
			// 삭제 성공 시 이동할 페이지
			// 성공했으니 목록페이지로 가라
			goPage = "redirect:/free/list.do";
			// 리다이렉트 하는 이유는? 내부에서 알아서 경로 좀 바꿔줘라
		} else {
			// 삭제 실패하면 다시 해당 no의 게시글 상세보기로 이동해라
			goPage = "redirect:/free/detail.do?freeNo=" + freeNo;
		}
		
		return goPage; // 작업이 다 끝났으면 마지막으로 내가 할 일을 뱉어내!
	}
	
}
