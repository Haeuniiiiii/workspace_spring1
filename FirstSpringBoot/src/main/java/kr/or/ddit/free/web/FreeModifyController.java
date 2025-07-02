package kr.or.ddit.free.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.free.service.IFreeService;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.FreeVO;

// 수정페이지, 수정기능, 삭제 기능을 처리할 컨트롤러
@Controller
@RequestMapping("/free")
public class FreeModifyController {
	
	// DI
	@Autowired
	private IFreeService freeService;
	
	// 수정 페이지 (현재는 get이지만 이따가 수정버튼 누르면 속상이 post로 변경될 예정)
	@GetMapping("/update.do")
	public String freeUpdateForm(int freeNo, Model model) {
		FreeVO freeVO = freeService.selectFree(freeNo);
		model.addAttribute("free", freeVO);
		model.addAttribute("status", "u");
		return "free/form";
	}
	
	
	// 수정 기능 (수정버튼 눌렀을 때 Post 로 속성이 변경되면 이쪽으로 와서 PostMapping됨 그래서 수정 기능이 실행)
	@PostMapping("/update.do")
	public String freeUpdate(FreeVO freeVO, Model model) {
		String goPage = ""; //이따 이동할 페이지 일단 공백으로 초기화시켜두기 수정성공 실패 여부로 어디로 갈지 모르니까
		ServiceResult result = freeService.updateFree(freeVO);
		if(result.equals(ServiceResult.OK)) {	// result에 담긴 결과가 수정 성공
			goPage = "redirect:/free/detail.do?freeNo=" + freeVO.getFreeNo();
		} else {	// 수정 실패
			model.addAttribute("free", freeVO);
			model.addAttribute("status", "u");
			goPage = "free/form";
		}
		return goPage;
	}
	
}
