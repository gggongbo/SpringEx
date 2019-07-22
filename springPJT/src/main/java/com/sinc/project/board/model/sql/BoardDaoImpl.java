package com.sinc.project.board.model.sql;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sinc.project.board.model.vo.BoardVO;
import com.sinc.project.board.model.vo.ReplyVO;

@Repository("boardD")
public class BoardDaoImpl implements BoardDao {

	@Resource(name = "sqlSession")
	private SqlSession sqlSession;

	@Override
	public List<BoardVO> listRow() {
		System.out.println("board dao listRow");
		return sqlSession.selectList("com.sinc.board.list");
	}

	@Override
	public int insertRow(BoardVO board) {
		System.out.println("board dao insertRow");
		return sqlSession.insert("com.sinc.board.insertBoard", board); /// 꼭 넘겨주어야 한다
	}

	@Override
	public List<BoardVO> searchRow(Map<String, String> map) {
		System.out.println("board dao searchRow");
		return sqlSession.selectList("com.sinc.board.searchAjax", map);
	}

	@Override
	public BoardVO readRow(BoardVO board) {
		System.out.println("board dao readRow");
		return sqlSession.selectOne("com.sinc.board.readBoard", board);
	}

	@Override
	public int deleteRow(BoardVO board) {
		System.out.println("board dao deleteRow");
		return sqlSession.delete("com.sinc.board.deleteBoard", board);
	}

	@Override
	public int insertReplyRow(ReplyVO reply) {
		System.out.println("board dao insertReplyRow");
		return sqlSession.insert("com.sinc.board.insertReply", reply);
	}

	@Override
	public List<ReplyVO> listReplyRow(int seq) {
		System.out.println("board dao listReplyRow");
		return sqlSession.selectList("com.sinc.board.listReply", seq);
	}

}
