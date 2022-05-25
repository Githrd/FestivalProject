package com.githrd.festival.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReviewVO {
	private int rno, fno;
	private float score;
	private String title, body, writer, wdate, fname, savename;
	private Date ww;

	public String getSavename() {
		return savename;
	}
	public void setSavename(String savename) {
		this.savename = savename;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public void setWdate() {
		SimpleDateFormat form = new SimpleDateFormat();
		wdate = form.format(ww);
	}
	public Date getWw() {
		return ww;
	}
	public void setWw(Date ww) {
		this.ww = ww;
	}
	
	@Override
	public String toString() {
		return "ReviewVO [rno=" + rno + ", fno=" + fno + ", score=" + score + ", title=" + title + ", body=" + body
				+ ", writer=" + writer + ", wdate=" + wdate + ", fname=" + fname + ", savename=" + savename + ", ww="
				+ ww + "]";
	}
}
