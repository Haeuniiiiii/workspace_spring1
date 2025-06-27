package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.SpringBootYseApplication;
import kr.or.ddit.mapper.IBookMapper;
/*
 *	Service 클래스는 비지니스 클래스가 위치하는 곳입니다.
 *  스프링 MVC 구조에서 서비스 클래스는 컨트롤러와 DAO(Mapeer)를 연결하는 역할을 합니다.
 *  @Service는 스프링에 서비스 클래스임을 알려준다. 
 */
@Service
public class BookServiceImpl implements IBookService{
	
	// DB 접근을 위해 Service인스턴스를 주입받는다. 
	@Autowired
	private IBookMapper mapper;
	
	/**
	 * ALT + SHIFT + J
	 * <p>책 등록</p>
	 * @since SpringBootYse 1.0
	 * @author ddit_june
	 * @param map 등록할 책 데이터
	 * @return 성공 책ID, 실패 null
	 */
	@Override
	public String insertBook(Map<String, Object> map) {
		// affectRowCount 변수에는 영향받은 행의 수가 담딘다. (등록성공시 1, 등록실패시 0)
		// insert 구문은 입력이 성공하면 1, 실패하면 0을 리턴합니다.
		int affectRowCount = mapper.insert(map);
		
		if(affectRowCount == 1) {
			// 결과가 성공일 시, map 인스턴스에 book 테이블의 pk 인 book_id 가 담겨있다.
			return map.get("book_id").toString();
		}
		return null;
	}

	
	// 조회하고 전달받은거 그대로 내보내면 됨
	/**
	 * <p>책 상세보기</p>
	 * @since SpringBootYse 1.0
	 * @author ddit_june
	 * @param map 책ID
	 * @return ID에 해당하는 책 정보 (Map)
	 */
	@Override
	public Map<String, Object> selectBook(Map<String, Object> map) {
		return mapper.selectBook(map);
	}


	/**
	 * <p>책 수정</p>
	 * @since SpringBootYse 1.0
	 * @author ddit_june
	 * @param map 수정할 책 정보
	 * @return 성공 1(true), 실패 0(false)
	 */
	@Override
	public boolean updateBook(Map<String, Object> map) {
		int affectRowCount = mapper.update(map);
		return affectRowCount == 1;
	}
	
	
	/**
	 * <p>책 삭제</p>
	 * @since SpringBootYse 1.0
	 * @author ddit_june
	 * @param map 책ID
	 * @return 성공 1(true), 실패 0(false)
	 */
	@Override
	public boolean deleteBook(Map<String, Object> map) {
		int affectRowCount = mapper.delete(map);
		return affectRowCount == 1;
	}

	/**
	 * <p>책 목록</p>
	 * @since SpringBootYse 1.0
	 * @author ddit_june
	 * @param 
	 * @return 성공 리스트(책), 실패 null
	 */
	@Override
	public List<Map<String, Object>> selectBookList(Map<String, Object> map) {
		return mapper.selectBookList(map);
	}

}
