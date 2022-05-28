package com.githrd.festival.vo;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import com.githrd.festival.vo.FileVO;

import java.text.*;
/*
 * 	파일 업로드 관련 VO
 * 						2022/05/29
 * 				
 * 						작성자 : 김수경		
*/
public class FileVO {
	private int review_img_fno, user_no, review_no, review_ori_fno, review_ssize;
	private long len;
	private String review_img_sname, review_img_sdir, id;
	private Date review_img_sdate;
	ArrayList<FileVO> list;
	public int getReview_img_fno() {
		return review_img_fno;
	}
	public void setReview_img_fno(int review_img_fno) {
		this.review_img_fno = review_img_fno;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public int getReview_ori_fno() {
		return review_ori_fno;
	}
	public void setReview_ori_fno(int review_ori_fno) {
		this.review_ori_fno = review_ori_fno;
	}
	public int getReview_ssize() {
		return review_ssize;
	}
	public void setReview_ssize(int review_ssize) {
		this.review_ssize = review_ssize;
	}
	public long getLen() {
		return len;
	}
	public void setLen(long len) {
		this.len = len;
	}
	public String getReview_img_sname() {
		return review_img_sname;
	}
	public void setReview_img_sname(String review_img_sname) {
		this.review_img_sname = review_img_sname;
	}
	public String getReview_img_sdir() {
		return review_img_sdir;
	}
	public void setReview_img_sdir(String review_img_sdir) {
		this.review_img_sdir = review_img_sdir;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getReview_img_sdate() {
		return review_img_sdate;
	}
	public void setReview_img_sdate(Date review_img_sdate) {
		this.review_img_sdate = review_img_sdate;
	}
	public ArrayList<FileVO> getList() {
		return list;
	}
	public void setList(ArrayList<FileVO> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "FileVO [review_img_fno=" + review_img_fno + ", user_no=" + user_no + ", review_no=" + review_no
				+ ", review_ori_fno=" + review_ori_fno + ", review_ssize=" + review_ssize + ", len=" + len
				+ ", review_img_sname=" + review_img_sname + ", review_img_sdir=" + review_img_sdir + ", id=" + id
				+ ", review_img_sdate=" + review_img_sdate + ", list=" + list + "]";
	}
	
	
	}

	
