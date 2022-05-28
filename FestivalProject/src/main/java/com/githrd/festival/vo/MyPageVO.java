package com.githrd.festival.vo;

import java.util.*;
import java.util.Date;

import com.githrd.festival.vo.FileVO;

import java.sql.*;
import java.text.*;

public class MyPageVO {
	private int user_no, fno, fest_no, review_no, review_fno, review_fno2, review_fno3, click, cnt, step, rno;
	private long review_score;
	private String id, fname, open_place, review_title, review_body, review_wname;
	private Date sdate, edate, review_wdate;
	ArrayList<FileVO> list;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public void setReview_score(long review_score) {
		this.review_score = review_score;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<FileVO> getList() {
		return list;
	}
	public void setList(ArrayList<FileVO> list) {
		this.list = list;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public int getFest_no() {
		return fest_no;
	}
	public void setFest_no(int fest_no) {
		this.fest_no = fest_no;
	}
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public int getReview_fno() {
		return review_fno;
	}
	public void setReview_fno(int review_fno) {
		this.review_fno = review_fno;
	}
	public int getReview_fno2() {
		return review_fno2;
	}
	public void setReview_fno2(int review_fno2) {
		this.review_fno2 = review_fno2;
	}
	public int getReview_fno3() {
		return review_fno3;
	}
	public void setReview_fno3(int review_fno3) {
		this.review_fno3 = review_fno3;
	}
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public long getReview_score() {
		return review_score;
	}
	public void setReview_score(int review_score) {
		this.review_score = review_score;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getOpen_place() {
		return open_place;
	}
	public void setOpen_place(String open_place) {
		this.open_place = open_place;
	}
	public String getReview_title() {
		return review_title;
	}
	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}
	public String getReview_body() {
		return review_body;
	}
	public void setReview_body(String review_body) {
		this.review_body = review_body;
	}
	public String getReview_wname() {
		return review_wname;
	}
	public void setReview_wname(String review_wname) {
		this.review_wname = review_wname;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	public Date getReview_wdate() {
		return review_wdate;
	}
	public void setReview_wdate(Date review_wdate) {
		this.review_wdate = review_wdate;
	}
	@Override
	public String toString() {
		return "MyPageVO [user_no=" + user_no + ", fno=" + fno + ", fest_no=" + fest_no + ", review_no=" + review_no
				+ ", review_fno=" + review_fno + ", review_fno2=" + review_fno2 + ", review_fno3=" + review_fno3
				+ ", click=" + click + ", cnt=" + cnt + ", step=" + step + ", rno=" + rno + ", review_score="
				+ review_score + ", id=" + id + ", fname=" + fname + ", open_place=" + open_place + ", review_title="
				+ review_title + ", review_body=" + review_body + ", review_wname=" + review_wname + ", sdate=" + sdate
				+ ", edate=" + edate + ", review_wdate=" + review_wdate + ", list=" + list + "]";
	}
	
	

}