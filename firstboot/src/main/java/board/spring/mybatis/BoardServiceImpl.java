package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // boardServiceImpl 이 된다. ("me")
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardDAO dao;
	
	public int insertBoard(BoardDTO dto) {
		return dao.insertBoard(dto);
	}
	
	public int getTotalBoard() {
		return dao.getTotalBoard();
	}

	@Override
	public List<BoardDTO> boardList(int[] limit) {
		 return dao.boardList(limit);
	}

	@Override
	public BoardDTO updateViewcountAndGetDetail(int seq) {
		int updaterows = dao.updateViewcount(seq); 
		return dao.getDetail(seq);
	}

	@Override
	public int deleteBoard(int seq) {
		return dao.deleteBoard(seq);
	}

	@Override
	public int updateBoard(BoardDTO dto) {
		return dao.updateBoard(dto);
	}

	@Override
	public List<BoardDTO> searchList(HashMap map) {
		return dao.searchList(map);
	}
	
	public int getSearchBoard(HashMap map) {
		return dao.getTotalBoard();
	}
	
	
	public BoardMemberDTO boardWriterInform(int seq) {
		return dao.boardWriterInform(seq);
	};
	
}
