package kr.or.ddit.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


/*
 * @Mapper 어노테이션은 인터페이스로 구성된 해당 객체를 myBatis 의 Mapper 로 등록할 때 사용합니다.
 * myBatis의 Mapper SQL 쿼리를 정의하고 실행하기 위한 역할을 합니다.
 * 우리가 MVC 패턴을 활용한 객체디향 프로그래밍 아키텍쳐를 생각해봤을 때, DAO부분이 Mapper 입니다.
 * 그렇기 때문에 DAO역할을 대체할 수 있는 것이죠. DAO는 SqlSessionFactory를 통해 만들어진
 * SqlsessionTemplate 객체를 이용해 요청헤 필요로 하는 데이터를 DB를 통해서  조회, 수정, 등록, 삭제 할 수 있습니다.
 * 그렇지만 Mapper 인터페이스는 구현체가 존재하지 않은 형태이지만 실제 흐름을 들여다보면
 * 우리가 설정한 DB와의 통신을 통해 요청에 따른 CRUD를 실행합니다.
 * 그 과정을 가능케 하는 것이 @Mapper 어노테이션 입니다.
 * 
 * @Mapper 어노테이션은 서버가 Runtime 시, 빈으로 등록되어 메모리에 올라갑니다.
 * 이때, MapperFactoryBean 객체를 통해서 Mapper로 등록된 인터페이스를 프록시 객체의 형태로 생성합니다.
 * MapperFactoryBean은 DB와 통신을 위해 SqlSession 객체가 필요한데 
 * 이를 SqlSessionFactory를 통해 SqlSessionTemplate을 활용합니다.
 * 여기서 SqlSessionFactory 와 SqlSessionTemplate 객체는 보통 legacy의 형태에선 
 * 직접적인 bean을 생성 후 사용해야 하지만, 스프링 부트에서는 pom.xml 내 'spring-boot-starter-data-jdbc' 또는
 * 'mybatis-spring-boot-starter'라이브러리의 의존성을 추가하면 SqlSessionFactory와 SqlSessionTemplate 객체의
 * 빈을 자동 등록해줍니다.
 * 그래서 MapperFactoryBean은 SqlSessionTemplate을 주입받아 DB 통신의 기능으로 활용합니다.
 * 
 * 그렇게 주입받은 SqlSessionTemplate과 Mapper 인터페이스를 가지고 MapperProxyFactory를 생성하고 MapperProxy객체를
 * 만드는데 이 녀석이 바로 Mapper 인터페이스의 내부 기능을 갖고 있는 구현체 입니다.
 * 
 * MapperFactoryBean(SqlSessionTemplate, Mapper(I)) 
 * => MapperProxyFactory => MapperProxy(InvocationHandler)
 * 
 * 그렇기 때문에 DAO를 직접 만들고, DAO에서 사용할 SqlSessionFactory와 SqlSessionTemplate 객체를
 * 직접 등록하지 않고 미리 정의되고 등록된 환경에서 @Mapper 어노테이션 하나만으로도 
 * 충분히 DAO의 역할을 대체할 Mapper를 사용할 수 있게 됩니다.
 * 
 * Mapper 인터페이스가 곧 실행할 쿼리의 주체가 되는데, 이는 Mapper 인터페이스 자체가 곧 'namespace'가 되고
 * Mapper 인터페이스의 기능명이 곧 Mapper xml의 태그에 설정된 'id'값이 됩니다.
 */
@Mapper
public interface IBookMapper {

	public int insert(Map<String, Object> map);

	public Map<String, Object> selectBook(Map<String, Object> map);

	public int update(Map<String, Object> map);

	public int delete(Map<String, Object> map);

	public List<Map<String, Object>> selectBookList(Map<String, Object> map);

}
