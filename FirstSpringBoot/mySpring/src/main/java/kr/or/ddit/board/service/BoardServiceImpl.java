package kr.or.ddit.board.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.mapper.IBoardMapper;

// 이렇게 붙이면 ApplicationContext에 자동 등록
//따라서 컨트롤러에서 DI 받을 수 있음
//@Autowired
//private IBoardService boardService;
//스프링은 이 BoardServiceImpl 객체를 찾아서 자동 주입
//서비스 계층 클래스임을 나타내는 어노테이션,스프링이 빈(bean)으로 등록하게 해줌

@Service
public class BoardServiceImpl implements IBoardService {
	
	// 스프링이 IBoardMapper 타입의 빈을 자동 주입해줌 (의존성 주입)
	@Autowired
	private IBoardMapper boardMapper;

	@Override
	public List<BoardVO> selectBoardList() {
		
		return boardMapper.selectBoardList();
	}

	@Override
	public int registBoard(BoardVO boardVO) {
		
		UUID uuid = UUID.randomUUID();
		
		boardVO.setBoardNo(uuid.toString());
		
		return boardMapper.registBoard(boardVO);
	}

	@Override
	public BoardVO selectBoardDetail(String boardNo) {
		boardMapper.addBoardHit(boardNo);
		return boardMapper.selectBoardDetail(boardNo);
	}

	@Override
	public int deleteBoard(BoardVO boardVO) {
		return boardMapper.deleteBoard(boardVO);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return boardMapper.updateBoard(boardVO);
	}
}
