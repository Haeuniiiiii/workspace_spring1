package kr.or.ddit.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Study {
	
	@GetMapping("/study.do")
	public String study() {
		return "/study/study";
	}
	@GetMapping("/next.do")
	public String next() {
		return "/study/next";
	}
	
	@GetMapping("/start.do")
	public String start() {
		return "/study/start";
	}
	@GetMapping("/spring.do")
	public String spring() {
		return "/study/spring";
	}
}
