package kr.or.ddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller // 메인컨트롤러 어노테이션을 붙임으로 서버가 런 하는 순간 자바빈으로 등록 됩니다! 요청을 받는 클래스다! 정의되었다.
public class MainController {

	@GetMapping("/")
	public String main() {
		log.info("main() started...!");
		return "main"; // 루트를 가지고 있다. view-resolver가 먼저 잡는다.
	}
	
}
