package kr.or.ddit.free.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.free.service.IFreeService;
import kr.or.ddit.vo.FreeVO;

@Controller
@RequestMapping("/free")
public class FreeInsertController {

	// 서비스에 대한 DI
	@Autowired
	private IFreeService freeService;

	// 자유게시판 등록작성 페이지
	@GetMapping("/form.do")
	public String freeForm() {
		return "free/form";
	}

	// form 태그를 통해 전달받은 데이터 처리
	// 자유게시판 등록 기능
	@PostMapping("/insert.do")
	public String freeInsert(FreeVO freeVO, Model model) {
		
		String goPage = ""; // 이동할 페이지 정보
		
		// 클라이언트에서 전달받은 데이터가 혹시나 에러가 발생했을 때 에러정보를 담을 공간
		Map<String, String> errors = new HashMap<>();
		
		// 전달받은 제목 데이터가 잘못됐을 때 (기본 유효성 검사를 진행 시, 또는 누락되었을 때) 
		if(StringUtils.isBlank(freeVO.getFreeTitle())) {
			errors.put("freeTitle", "제목을 입력해주세요!");
		}
		
		// 전달받은 내용 데이터가 잘못됐을 때 (기본 유효성 검사를 진행 시, 또는 누락되었을 때) 
		if(StringUtils.isBlank(freeVO.getFreeContent())) {
			errors.put("freeContent", "내용을 입력해주세요!");
		}
		
		// 에러가 발생했을 때
		if(errors.size() > 0) {
			model.addAttribute("errors", errors);
			model.addAttribute("free", freeVO);
			goPage = "free/form";
		} else {
		// 정상적인 데이터가 왔을 떄
			freeVO.setFreeWriter("a001");	// 로그인 처리가 되지 않았으므로 아이디 'a001' 미리 세팅
			ServiceResult result = freeService.insertFree(freeVO);	// 자유게시판 등록 성공
			if(result.equals(ServiceResult.OK)) {	// 등록 성공하면 리다이렉트로 디테일 페이지로 갈 수 있게 (no기준)
				goPage = "redirect:/free/detail.do?freeNo=" + freeVO.getFreeNo();
			} else {	// 등록 실패하면 다시 작성폼으로 돌아오게
				goPage = "free/form";
			}
		}
		return goPage;
	}

}
