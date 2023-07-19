package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@Configuration //설정파일 이땐 순서중요한데 
//@ComponentScan(베이스패키지)
//class A{}


@Mapper //순서상관없어
@Repository //연결객체란뜻.?
//인터페이스형태로 바꿔줌. , 구현안하니까 세션안씀. /같은이름 sql호출하는걸로보고 구현은안함.
//mapping.xml 서 실행하는걸로 . 1.인터페이스로바꿈. 2.구현부분은 없어짐. 3.@mapper
//mapping.mxl 맵핑파일 설정됨. ->sql가져다쓸 객체누군지 알려줬음.<mapper namespace=
//mybatis-config.xml에 dto 알리아스되어있음.

public interface BoardDAO {
	public int insertBoard(BoardDTO dto) ;
	
	public int getTotalBoard() ;

	public List<BoardDTO> boardList(int[] limit);
	
	public int updateViewcount(int seq) ;
	
	public BoardDTO getDetail(int seq);
	
	public int deleteBoard(int seq) ;
	
	public int updateBoard(BoardDTO dto) ;
	
	public List<BoardDTO> searchList(HashMap map); //조건맞는결과가 하나만나오면 boardDTO, 하나이상이면 list
	
	public int getSearchBoard(HashMap map);
	
	public BoardMemberDTO boardWriterInform(int seq);
	
}
