/**
 *  멤버(member) SQL 클래스이다.
 *  ");author	이승연
 *  ");since	2022/05/22
 *  ");version	v.1.0
 * 			작업이력 ]
 * 				2022.05.22	-	클래스제작
 * 								담당자 : 이승연
 *
 */
package com.githrd.festival.sql;

public class MemberSQL {
	public final int SEL_LOGIN_CNT	= 1001;
	public final int SEL_NAME_INFO	= 1002;
	public final int SEL_ID_CHECK	= 1003;
	public final int SEL_FIND_MAIL	= 1004;
	public final int SEL_FIND_TEL	= 1005;
	public final int SEL_FIND_PW	= 1006;
	
	public final int UPDATE_PW		= 2001;
	
	public final int ADD_MEMBER		= 3001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_LOGIN_CNT:
			buff.append("SELECT ");
			buff.append("    COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("    member ");
			buff.append("WHERE ");
			buff.append("    user_id = ? ");
			buff.append("    AND user_pw = ? ");
			break;
		
		case SEL_NAME_INFO:
			buff.append("SELECT ");
			buff.append("    USER_NAME ");
			buff.append("FROM ");
			buff.append("    member ");
			buff.append("WHERE ");
			buff.append("    user_id = ? ");
			break;
			
		case SEL_ID_CHECK:
			buff.append("SELECT ");
			buff.append("    COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("    member ");
			buff.append("WHERE ");
			buff.append("    user_id = ? ");
			break;
			
		case SEL_FIND_MAIL:
			buff.append("SELECT ");
			buff.append("    user_id ");
			buff.append("FROM ");
			buff.append("    member ");
			buff.append("WHERE ");
			buff.append("    user_mail = ? ");
			buff.append("    AND isshow = 'Y' ");
			break;
			
		case SEL_FIND_TEL:
			buff.append("SELECT ");
			buff.append("    user_id ");
			buff.append("FROM ");
			buff.append("    member ");
			buff.append("WHERE ");
			buff.append("    user_tel = ? ");
			buff.append("    AND isshow = 'Y' ");
			break;
			
		case SEL_FIND_PW:
			buff.append("SELECT ");
			buff.append("    COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("    member ");
			buff.append("WHERE ");
			buff.append("    user_id = ? ");
			buff.append("    AND isshow = 'Y' ");
			break;
			
		case UPDATE_PW:
			buff.append("UPDATE ");
			buff.append("    member ");
			buff.append("SET ");
			buff.append("    user_pw = ? ");
			buff.append("WHERE ");
			buff.append("    user_id = ? ");
			break;
			
		case ADD_MEMBER:
			buff.append("INSERT INTO ");
			buff.append("    member (user_no, user_name, user_id, user_pw, user_birth, user_tel, user_mail, user_add, user_gen) ");
			buff.append("VALUES ( ");
			buff.append("    (SELECT NVL(MAX(user_no) + 1, 101) FROM member), ");
			buff.append("    ?, ?, ?, ?, ?, ?, ?, ? ");
			buff.append(") ");
			break;
		}
		return buff.toString();
	}
}
