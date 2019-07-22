package com.sinc.project.board.model.vo;


/*
 CREATE TABLE SPRING_REPLY_TBL (
 	RSEQ NUMBER PRIMARY KEY,
 	RWRITER VARCHAR2(50),
 	RCONTENT VARCHAR2(1000),
 	RREGDATE DATE DEFAULT SYSDATE,
 	SEQ REFERENCES SPRING_BOARD_TBL (SEQ)
 );
 
 CREATE SEQUENCE REPLY_SEQ;
 
 */
public class ReplyVO {

	private int rSeq, seq;
	private String rWriter, rContent, rRegdate;
	
	public ReplyVO() {
		super();
	}

	public ReplyVO(int rSeq, int seq, String rWriter, String rContent, String rRegdate) {
		super();
		this.rSeq = rSeq;
		this.seq = seq;
		this.rWriter = rWriter;
		this.rContent = rContent;
		this.rRegdate = rRegdate;
	}

	public int getrSeq() {
		return rSeq;
	}

	public void setrSeq(int rSeq) {
		this.rSeq = rSeq;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getrWriter() {
		return rWriter;
	}

	public void setrWriter(String rWriter) {
		this.rWriter = rWriter;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public String getrRegdate() {
		return rRegdate;
	}

	public void setrRegdate(String rRegdate) {
		this.rRegdate = rRegdate;
	}

	@Override
	public String toString() {
		return "ReplyVO [ " + rSeq + ", " + rWriter + ", " + rContent + ", " + rRegdate + ", " + seq + " ]";
	}
	
	
	
	
	
	

}
