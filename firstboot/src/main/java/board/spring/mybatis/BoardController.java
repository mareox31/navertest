package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	@Qualifier("boardServiceImpl") // ("me") 컨트롤러한테 서비스 사용하고있는거 정확히 알려줘야함.
	BoardService service;
	
	@RequestMapping("/")
	public String start() {
		return "board/start";
	}
	
	@GetMapping("/boardwrite")
	public String writeform() {
		return "board/writingform";
	}
	
	@PostMapping("/boardwrite")
	public ModelAndView writeprocess(BoardDTO dto){
		int insertcount = service.insertBoard(dto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("insertcount", insertcount);
		//mv.setViewName("board/writeresult");
		//mv.setViewName("redirect:/boardlist");//모델2개 전달받는 리스트뷰  
		mv.setViewName("board/start");
		return mv;
	}
	
	@RequestMapping("/boardlist")
	public ModelAndView boardlist(@RequestParam(value="page", required=false, defaultValue="1") int page) {
		//전체 게시물 갯수 (9) 가져와서 몇페이지까지 (1페이지당 4개 게시물) -  1 2 3
		int totalBoard = service.getTotalBoard();
	
		//page번호 해당 게시물 4개 리스트 조회 
		int limitcount = 4;
		int limitindex = (page-1)*limitcount;
		int limit [] = new int[2];
		limit[0] = limitindex;
		limit[1] = limitcount;
		
		/*  1.  List<BoardDTO> -- 서비스 메소드 (limitindex,  limitcount);
		 *  2.  board-mapping.xml
		 * select * from board order by writingtime desc limit 배열[0],배열[1]
		 *  3. 1번 결과를 모델로 추가 저장
		 *  4. 뷰 3번 모델 저장 테이블 태그 출력
		 * */
		
		List<BoardDTO> list = service.boardList(limit);
				
		ModelAndView mv = new ModelAndView();
		mv.addObject("totalBoard", totalBoard);
		mv.addObject("boardList", list);
		
		mv.setViewName("board/list");
		return mv;
	}
	
	@RequestMapping("/boarddetail")
	public ModelAndView boarddetail(int seq) {
		ModelAndView mv = new ModelAndView();
		BoardDTO dto = service.updateViewcountAndGetDetail(seq);
		mv.addObject("detaildto", dto);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@RequestMapping("/boarddelete")
	public String boarddelete(int seq){
		service.deleteBoard(seq);
		//return "board/list"; //list.jsp 이동(모델 전달 없다 - nULLpOINTER.. 500) 
		return "redirect:/boardlist"; // boardlist 매핑 메소드 실행 호출
	}

	@RequestMapping("/boardupdate")
	public String boardupdate(BoardDTO dto) {
		service.updateBoard(dto);
		return "redirect:/boardlist";
	}

	@RequestMapping("/boardsearchlist")
	public ModelAndView boardsearchlist(
			//입력안해도 기본값.
			@RequestParam(value="item", required = false, defaultValue="all")String item, 
			@RequestParam(value="word", required = false, defaultValue="")String word
//페이징처리용
//			,
//			@RequestParam(value="item", required = false, defaultValue="1")int page
			) {
		//파라메터 몇개 전달? = > select * from bosrd where ? like ?
		//select * from bosrd where ? like ? or ? like ? or ? like ?
		//검색 항목명에 따라 다르게 만들어야 한다. 
		//db ->mapping전달하는거 2개이상. dto값도 아님, 배열 or 맵 or 리스트 컬렉션 타입 이용해야함.
		//dto연관값도아니고, 하나로 묶여서 변수처럼 전달해야하므로, 이번엔 맵 이용.
		HashMap map = new HashMap();
		if(item.equals("all")) { item = null;} //all컬럼이름 못쓰니까. 비워둠.
		map.put("colname",item); //키 콜 네임 검색항목. 
		map.put("colvalue","%" + word + "%"); //검색어 %번째%
//		map.put("limitidex",(page-1)*4 );//페이지번호받으면 -1 *리미트 카운트곱한거.=>서비스->dao->sql 전달받는 sql도 리미트절받는거로바꿔야함.
//		map.put("limitcount", 4);//한페이지몇개
		
		List<BoardDTO> searchlist = service.searchList(map); //보드서비스임플에게 저 맵으로 시킴.
		int searchcount = service.getSearchBoard(map);
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardList",searchlist);
		mv.addObject("totalBoard", searchcount); //이미구현되어있어서 서치리스트에 어트리뷰트 받아야하는 파라메터이름. 
		
		//몇페이지까지 보여줄지 전달해야함.!!------------------------검색 된 걸 가지고 다시 몇개 보여줄지 해야함. 
		
		mv.setViewName("board/searchlist");
		return mv;
	}
	
	
	//조인 결과만 확인해보자. 
	@RequestMapping("/boardwriterinform") //실행은그냥 ?seq=3으로 볼것.
	public ModelAndView boardwriterinform(int seq) {
//		System.out.println(writerdto.getTitle() + ":" + writerdto.getMember().memberid);-확인용
		BoardMemberDTO writerdto = service.boardWriterInform(seq);
		ModelAndView mv = new ModelAndView();
		mv.addObject("writerdto", writerdto);//1번글 쓴 작성자. 
		mv.setViewName("board/writerinform");//jsp
		return mv;
	}
	
	
}







