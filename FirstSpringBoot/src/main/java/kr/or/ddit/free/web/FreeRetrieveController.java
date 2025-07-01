package kr.or.ddit.free.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import kr.or.ddit.board.web.BoardInsertController;
import kr.or.ddit.free.service.IFreeService;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Controller
@RequestMapping("/free")
public class FreeRetrieveController {

	// 서비스에 대한 DI
	@Autowired
	private IFreeService freeService;

	// 자유게시판 목록 페이지
	@RequestMapping("/list.do")
	public String freeList(@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage
						  ,@RequestParam(required = false, defaultValue = "title") String serachType
						  ,@RequestParam(required = false) String searchWord
						  ,Model model) {
		
		PaginationInfoVO<FreeVO> pVO = new PaginationInfoVO<>();
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
	
}
