package com.githrd.festival.dao;

import java.sql.*;
import java.util.*;
import java.util.Date;

import com.githrd.festival.db.*;
import com.githrd.festival.sql.*;
import com.githrd.festival.util.PageUtil;
import com.githrd.festival.vo.*;
import com.githrd.festival.vo.MyPageVO;

public class MyPageDao {
	private FesDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private MyPageSQL bSQL;
	
	public MyPageDao() {
		db = new FesDBCP();
		bSQL = new MyPageSQL();
	}
	
	// 단일 파일 정보 데이터베이스 입력 전담 처리함수
	public int addFileInfo(FileVO fVO) {
		int cnt = 0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.INSERT_FILEINFO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, fVO.getId());
			pstmt.setInt(2, fVO.getReview_ori_fno());
			pstmt.setString(3, fVO.getReview_img_sname());
			pstmt.setString(4, fVO.getReview_img_sdir());
			pstmt.setLong(5, fVO.getLen());
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 다중파일 데이터베이스 입력 전담 처리 함수
	public int addFileList(ArrayList<FileVO> list) {
		int cnt = 0;
		for(FileVO fVO : list) {
			cnt += addFileInfo(fVO);
		}
		
		return cnt;
	}
	
	// 게시글 정보입력 데이터베이스 작업 전담 처리함수
	public int addBoard(MyPageVO bVO) {
		int cnt = 0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.INSERT_BOARD);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, bVO.getId());
			pstmt.setString(2, bVO.getReview_title());
			pstmt.setString(3, bVO.getReview_body());
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 게시판 데이터베이스 등록 전담 처리함수
	public int insertBoardData(MyPageVO bVO) {
		int cnt = 0;
		cnt = addBoard(bVO);
		if(cnt != 1) {
			return cnt;
		}
		cnt = addFileList(bVO.getList());
		if(cnt != bVO.getList().size()) {
			return -1;
		}
		return cnt;
	}
	

	public int getTotalCount() {
		int cnt = 0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_TOTAL_COUNT);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return cnt;
	}
	
	public ArrayList<MyPageVO> getBoardList(PageUtil page){
		ArrayList<MyPageVO> list = new ArrayList<MyPageVO>();
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_BOARD_LIST);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, page.getStartCont());
			pstmt.setInt(2, page.getEndCont());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MyPageVO bVO = new MyPageVO();
				bVO.setUser_no(rs.getInt("uno"));
				bVO.setId(rs.getString("id"));
				bVO.setReview_title(rs.getString("title"));
				bVO.setReview_wdate(rs.getDate("wdate"));
				bVO.setClick(rs.getInt("click"));
				bVO.setCnt(rs.getInt("cnt"));
				
				list.add(bVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return list;
	}
	
	// 게시글 상세보기 데이터조회 전담 처리함수
	public MyPageVO getBoardDetail(int bno) {
		MyPageVO bVO = new MyPageVO();
		ArrayList<FileVO> list = new ArrayList<FileVO>();
		bVO.setList(list);
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_BOARD_DETAIL);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.isFirst()) {
					bVO.setBno(rs.getInt("bno"));
					bVO.setId(rs.getString("id"));
					bVO.setTitle(rs.getString("title"));
					bVO.setBody(rs.getString("body").replaceAll("\r\n", "<br>"));
					bVO.setWdate(rs.getDate("wdate"));
					bVO.setWtime(rs.getTime("wdate"));
					bVO.setClick(rs.getInt("click"));
				}
				FileVO fVO = new FileVO();
				fVO.setFno(rs.getInt("fno"));
				fVO.setOriname(rs.getString("oriname"));
				fVO.setSavename(rs.getString("savename"));
				fVO.setDir(rs.getString("dir"));
				list.add(fVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return bVO;
	}
	public ArrayList<MyPageVO> getReviewList(){
		ArrayList<MyPageVO> list = new ArrayList<MyPageVO>();
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_REV_LIST);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
						
			while(rs.next()) {
				MyPageVO bVO = new MyPageVO();
				bVO.setFname(rs.getString("fname"));
				bVO.setFno(rs.getInt("fno"));
				
				list.add(bVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return list;
	}
	
}