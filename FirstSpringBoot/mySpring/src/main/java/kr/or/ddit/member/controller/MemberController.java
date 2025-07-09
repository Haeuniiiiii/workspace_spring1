package kr.or.ddit.member.controller;


import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.HomeController;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
//	@Inject 	둘중에 하나 쓰기 // 의존성 주입 ... 주입하다 
	@Autowired
	private IMemberService memberService;
	
	@RequestMapping(value ="/getMemberList.do", method = RequestMethod.GET)
	public void getMemberList() {
		List<MemberVO> memList = memberService.getMemberList();
//		logger.info("memList : " + memList); 	// String + 연산자는 성능이 별로 안좋음 
											 	// 내가 보고 싶지 않은 레벨까지도 +가 있을 경우에는 한번씩 훑고 진행됨
		logger.info("memList : {}", memList); 
	}
}
