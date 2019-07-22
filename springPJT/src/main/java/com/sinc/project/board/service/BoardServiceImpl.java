package com.sinc.project.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.project.board.model.sql.BoardDao;
import com.sinc.project.board.model.vo.BoardVO;
import com.sinc.project.board.model.vo.ReplyVO;

@Service("boardS")
public class BoardServiceImpl implements BoardService {

	@Resource(name = "boardD") // @Autowired도 가능
	private BoardDao dao;

	@Override
	public List<BoardVO> listService() {

		System.out.println("board service list");
		return dao.listRow();
	}

	@Override
	public int insertService(BoardVO board) {
		System.out.println("board service insert");
		return dao.insertRow(board);
	}

	@Override
	public List<BoardVO> searchService(Map<String, String> map) {
		System.out.println("board service search");
		return dao.searchRow(map);
	}

	@Override
	public BoardVO readService(BoardVO board) {
		System.out.println("board service read");
		return dao.readRow(board);
	}

	@Override
	public int deleteService(BoardVO board) {
		System.out.println("board service delete");
		return dao.deleteRow(board);
	}

	@Override
	public int insertReplyService(ReplyVO reply) {
		System.out.println("board service insertReply");
		return dao.insertReplyRow(reply);
	}

	@Override
	public List<ReplyVO> listReplyService(int seq) {
		System.out.println("board service listReply");
		return dao.listReplyRow(seq);
	}

}
