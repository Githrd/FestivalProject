package com.githrd.festival.dao;

import java.sql.*;

import com.githrd.festival.db.*;
import com.githrd.festival.sql.*;

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
}
