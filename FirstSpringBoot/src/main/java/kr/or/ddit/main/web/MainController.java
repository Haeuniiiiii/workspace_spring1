package kr.or.ddit.main.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import kr.or.ddit.board.web.BoardModifyController;
import kr.or.ddit.main.service.IMainService;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {

    private final BoardModifyController boardModifyController;

    MainController(BoardModifyController boardModifyController) {
        this.boardModifyController = boardModifyController;
    }

	
    @Autowired
    private IMainService mainService;
    
    @Autowired
	private INoticeService noticeService;

    @GetMapping({"/", "/main.do"})
    public String mainPage(Model model) {
    	// 메인화면 자유게시판 5개
        PaginationInfoVO<FreeVO> pagingVO = new PaginationInfoVO<>(5, 1); // 5개까지만
        pagingVO.setCurrentPage(1); // 첫 페이지

        int totalRecord = mainService.selectFreeCount(pagingVO);
        pagingVO.setTotalRecord(totalRecord);

        List<FreeVO> dataList = mainService.selectFreeList(pagingVO);
        pagingVO.setDataList(dataList);

        model.addAttribute("mainFreeList", pagingVO); 
        
        
        // 메인화면 일반게시판 5개
        PaginationInfoVO<BoardVO> pagingBoardVO = new PaginationInfoVO<>(5, 1); // 5개까지만
        pagingVO.setCurrentPage(1); // 첫 페이지
        
        totalRecord = mainService.selectBoardCount(pagingBoardVO);
        pagingVO.setTotalRecord(totalRecord);
        
        List<BoardVO> dataBoardList = mainService.selectBoardList(pagingBoardVO);
        pagingBoardVO.setDataList(dataBoardList);
        
        model.addAttribute("mainBoardList", pagingBoardVO); 
        
    	// System.out.println(dataList);
        // 도전해본 방법 end -----------------------------------------------------------
        
        
        // 미루의 팁을 얻어서 다른 방법도 해보았습니다!--------------------------------------
        // 메인화면 notice
        PaginationInfoVO<NoticeVO> pagingNoticeVO = new PaginationInfoVO<>(5, 1);
        // startRow endRow startPage endPage 가 결정된다.
        pagingNoticeVO.setCurrentPage(1);
 		
 		// 총 게시글 수 가져오기
 		totalRecord = noticeService.selectNoticeCount(pagingNoticeVO);
 		// totalPage가 결정된다.
 		pagingNoticeVO.setTotalRecord(totalRecord);
 		
 		// startRow endRow 영역에 해당하는 게시글 목록 조회
 		List<NoticeVO> dataList1 = noticeService.selectNoticeList(pagingNoticeVO);
 		pagingNoticeVO.setDataList(dataList1);
 		
 		model.addAttribute("pagingNoticeVO", pagingNoticeVO);
        
        return "main";
    }

}
