package kr.or.ddit.member.vo;

import lombok.Data;

// Maven Dependencies lombok jar rus as 자바 어플리케이션 

@Data
public class MemberVO { 
	private String memId;
	private String memPw;
	private String memName;
	private String emailId;
	private String memTel;
	
	private boolean foreigner;    // 외국인 여부
	private String gender;	      // 성별 
	private String[] hobbyArray; 
	private String hobby;
}
