package com.sinc.project.board.model.sql;

import java.util.List;
import java.util.Map;

import com.sinc.project.board.model.vo.BoardVO;
import com.sinc.project.board.model.vo.ReplyVO;

public interface BoardDao {

	public List<BoardVO> listRow();

	public int insertRow(BoardVO board);

	public List<BoardVO> searchRow(Map<String, String> map);

	public BoardVO readRow(BoardVO board);

	public int deleteRow(BoardVO board);

	public int insertReplyRow(ReplyVO reply);

	public List<ReplyVO> listReplyRow(int seq);

}
