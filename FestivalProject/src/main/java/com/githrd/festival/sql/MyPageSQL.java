package com.githrd.festival.sql;

/*
 * 	마이페이지 관련 SQL
 * 						2022/05/29
 * 				
 * 						작성자 : 김수경		
*/
public class MyPageSQL {
	public final int SEL_BOARD_LIST			=	1001;
	public final int SEL_TOTAL_COUNT		=	1002;
	public final int SEL_BOARD_DETAIL		=	1003;
	
	public final int INSERT_BOARD			= 	3001;
	public final int INSERT_FILEINFO		= 	3002;
	
	public final int SEL_REV_LIST			= 	4001;

	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_REV_LIST:
			buff.append("SELECT ");
			buff.append("    fname, fno ");
			buff.append("FROM ");
			buff.append("    festival_info ");
		break;
		case INSERT_BOARD:
			buff.append("INSERT INTO ");
			buff.append("	festival_review(review_no, review_wname, review_title, review_wdate, click) ");
			buff.append("VALUES( ");
			buff.append("	(SELECT NVL(MAX(review_no) + 1, 100001) FROM festival_review), ");
			buff.append("	(SELECT user_no FROM member WHERE id = ? ), ");
			buff.append("	?, ? ");
			buff.append(") ");
			break;
		case INSERT_FILEINFO:
			buff.append("INSERT INTO ");
			buff.append("	review_img_file(review_img_fno, review_ori_fno, review_img_sname, review_img_sdir) ");
			buff.append("VALUES( ");
			buff.append("	(SELECT NVL(MAX(review_img_fno) + 1, 10000001) FROM review_img_file), ");
			buff.append("	(SELECT MAX(review_no) FROM festival_review WHERE fruno = (SELECT user_no FROM member WHERE id = ? )), ");
			buff.append("	?, ?, ?, ? ");
			buff.append(") ");
			break;
		case SEL_TOTAL_COUNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	board ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			break;
		case SEL_BOARD_LIST:
			buff.append("SELECT ");
			buff.append("    user_no, id, review_title, review_wdate, click, cnt ");
			buff.append("FROM ");
			buff.append("    ( ");
			buff.append("        SELECT ");
			buff.append("            ROWNUM rno, user_no, id, review_title, review_wdate, click, cnt ");
			buff.append("        FROM ");
			buff.append("            ( ");
			buff.append("                SELECT ");
			buff.append("                    review_no, id, review_title, review_wdate, click, NVL(cnt, 0) cnt ");
			buff.append("                FROM ");
			buff.append("                    festival_review f, member m, ");
			buff.append("                    ( ");
			buff.append("                        SELECT ");
			buff.append("                            review_no, COUNT(*) cnt ");
			buff.append("                        FROM ");
			buff.append("                            festival_img_file ");
			buff.append("                        WHERE ");
			buff.append("                            isshow = 'Y' ");
			buff.append("                        GROUP BY ");
			buff.append("                            review_no ");
			buff.append("                    ) ");
			buff.append("                WHERE ");
			buff.append("                    fruno = user_no ");
			buff.append("                    AND fbno(+) = fruno ");
			buff.append("                    AND b.isshow = 'Y' ");
			buff.append("                    AND m.isshow = 'Y' ");
			buff.append("                ORDER BY ");
			buff.append("                    wdate DESC ");
			buff.append("            ) ");
			buff.append("    ) ");
			buff.append("WHERE ");
			buff.append("    rno BETWEEN ? AND ? ");
			break;
		case SEL_BOARD_DETAIL:
			buff.append("SELECT ");
			buff.append("    bno, id, title, body, wdate, click, fno, oriname, savename, dir ");
			buff.append("FROM ");
			buff.append("    board b, member m, fileinfo f ");
			buff.append("WHERE ");
			buff.append("    bno = fbno(+) ");
			buff.append("    AND bmno = mno ");
			buff.append("    AND b.isshow = 'Y' ");
			buff.append("    AND bno = ? ");
			break;
		}
		return buff.toString();
	}
}