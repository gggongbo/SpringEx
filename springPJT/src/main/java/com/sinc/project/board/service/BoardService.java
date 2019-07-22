package com.sinc.project.board.service;

import java.util.List;
import java.util.Map;
import com.sinc.project.board.model.vo.BoardVO;
import com.sinc.project.board.model.vo.ReplyVO;

public interface BoardService {

	public List<BoardVO> listService();

	public int insertService(BoardVO board);

	public List<BoardVO> searchService(Map<String, String> map);

	public BoardVO readService(BoardVO board);

	public int deleteService(BoardVO board);

	public int insertReplyService(ReplyVO reply);

	public List<ReplyVO> listReplyService(int seq);

}
