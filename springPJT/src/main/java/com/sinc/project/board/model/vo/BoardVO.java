package com.sinc.project.board.model.vo;

import java.util.List;

/*
CREATE TABLE SPRING_BOARD_TBL (
	SEQ 	NUMBER PRIMARY KEY,
	TITLE   VARCHAR2(50) NOT NULL,
	CONTENT VARCHAR2(4000),
	WRITER  VARCHAR2(50) REFERENCES SPRING_MEM_TBL(ID),
	REGDATE DATE DEFAULT SYSDATE,
	VIEWCNT NUMBER DEFAULT 0
 );
 
 CREATE SEQUENCE BOARD_SEQ;
 
 INSERT INTO SPRING_BOARD_TBL
 VALUES(BOARD_SEQ.NEXTVAL, '공지', '냉무', 'admin', DEFAULT, DEFAULT);
 
 INSERT INTO SPRING_BOARD_TBL
 VALUES(BOARD_SEQ.NEXTVAL, '공지', '쉬는시간', 'admin', DEFAULT, DEFAULT);
 
 COMMIT;
 */
public class BoardVO {

	private int 	seq;
	private String  title, content, writer, regdate;
	private int 	viewcnt;
	private List<ReplyVO> rlist;
	
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardVO(int seq, String title, String content, String writer, String regdate, int viewcnt, List<ReplyVO> rlist) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.viewcnt = viewcnt;
		this.rlist = rlist;
	}
	//////////////////////////////////
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	
	public List<ReplyVO> getRlist() {
		return rlist;
	}
	public void setRlist(List<ReplyVO> rlist) {
		this.rlist = rlist;
	}
	
	@Override
	public String toString() {
		return "BoardVO [ " + seq + ", " + title + ", " + content + ", " + writer + ", " + regdate + ", " + viewcnt + ", " + rlist + " ]";
	}
	
	
}
