package com.githrd.festival.dao;

import java.sql.*;

import com.githrd.festival.db.*;
import com.githrd.festival.sql.*;
import com.githrd.festival.vo.*;

public class MemberDao {
	private FesDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private MemberSQL mSQL;
	
	public MemberDao() {
		db = new FesDBCP();
		mSQL = new MemberSQL();
	}
	
	// 로그인 데이터베이스 작업 전담 처리함수
	public int getLogin(String id, String pw) {
		int cnt = 0;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_LOGIN_CNT);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 로그인시 사용자 이름 가져오는 전담 처리함수
	public String getName(String id) {
		String name = null;
		
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_NAME_INFO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			name = rs.getString("user_name");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return name;
	}
	
	// 회원가입 전담 처리함수
	public int addMember(MemberVO mVO) {
		int cnt = 0;
		
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.ADD_MEMBER);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, mVO.getName());
			pstmt.setString(2, mVO.getId());
			pstmt.setString(3, mVO.getPw());
			pstmt.setString(4, mVO.getBirth());
			pstmt.setString(5, mVO.getTel());
			pstmt.setString(6, mVO.getMail());
			pstmt.setString(7, mVO.getAdd());
			pstmt.setString(8, mVO.getGen());
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 아이디 중복검사 처리 함수
	public int idCheck(String id) {
		int cnt = 0;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_ID_CHECK);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);			
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
 		} catch(Exception e) {
 			e.printStackTrace();
 		} finally {
 			db.close(rs);
 			db.close(pstmt);
 			db.close(con);
 		}
		return cnt;
	}
	
	// 아이디 찾기 처리 함수(이메일)
	public String getIdbyMail(String mail) {
		String id = null;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_FIND_MAIL);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, mail);
			rs = pstmt.executeQuery();
			rs.next();
			if(rs == null) {
				return id;
			}
			id = rs.getString("user_id");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return id;
	}
	// 아이디 찾기 처리 함수(핸드폰번호)
	public String getIdbyTel(String tel) {
		String id = null;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_FIND_TEL);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, tel);
			rs = pstmt.executeQuery();
			rs.next();
			if(rs == null) {
				return id;
			}
			id = rs.getString("user_id");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return id;
	}
	
	// 비밀번호 찾기 처리 함수
	public int getIdbyPw(String id) {
		int cnt = 0;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_FIND_PW);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 비밀번호 변경 처리 함수
	public int changePw(String id, String pw) {
		int cnt = 0;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.UPDATE_PW);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	//회원번호로 회원 정보 조회 전담 처리함수
	public MemberVO getMnoInfo(String id) {
		/*
			이함수가 데이터베이스에서 꺼내올 데이터는
			회원 한명의 데이터이기 때문에
			VO를 만들고 채워서 반환해주면 작업이 끝난다.
		 */
		MemberVO mVO = new MemberVO();
		// con
		con = db.getCon();
		// sql
		String sql = mSQL.getSQL(mSQL.SEL_ID_INFO);
		// pstmt
		pstmt = db.getPSTMT(con, sql);
		try {
			// setting variable
			pstmt.setString(1, id);
			// send and receive
			rs = pstmt.executeQuery();
			// get Data
			rs.next();
			// vo setting
			mVO.setId(rs.getString("user_id"));
			mVO.setName(rs.getString("user_name"));
			mVO.setBirth(rs.getString("user_birth"));
			mVO.setJdate(rs.getDate("join_date"));
			mVO.setMail(rs.getString("user_mail"));
			mVO.setAdd(rs.getString("user_add"));
			mVO.setTel(rs.getString("user_tel"));
			mVO.setSdate();
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		// return
		return mVO;
}
}
