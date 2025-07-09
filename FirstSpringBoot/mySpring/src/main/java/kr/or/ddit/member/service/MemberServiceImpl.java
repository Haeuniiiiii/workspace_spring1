package kr.or.ddit.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.mapper.IMemberMapper;
import kr.or.ddit.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements IMemberService {
	
	@Autowired
	private IMemberMapper memberMapper;
	
	@Override
	public List<MemberVO> getMemberList() {
		
		return memberMapper.getMemberList();
	}

}
