package kr.or.ddit.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	// 메인 페이지 출력
	@GetMapping({"/", "/main.do"})
	public String main() {
		return "main";
	}

}
