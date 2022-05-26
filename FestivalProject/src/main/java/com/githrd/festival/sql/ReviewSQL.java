package com.githrd.festival.sql;

public class ReviewSQL {
	public final int SEL_MAIN_REVIEW	= 1001;
	public final int SEL_AVG_SCORE		= 1002;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_MAIN_REVIEW:
			buff.append("SELECT ");
			buff.append("    review_no, fest_name, review_title, review_body, review_wname, review_score ");
			buff.append("FROM ");
			buff.append("    FESTIVAL_INFO i, FESTIVAL_REVIEW r ");
			buff.append("WHERE ");
			buff.append("    i.FEST_NO = r.FEST_NO ");
			buff.append("    AND i.fest_no = ? ");
			buff.append("    AND ROWNUM < 6 ");
			break;
		
		case SEL_AVG_SCORE:
			buff.append("SELECT ");
			buff.append("    ROUND(AVG(review_score),1) score, r.fest_no fno ");
			buff.append("    ,(SELECT fest_img_sname FROM festival_img_file i WHERE r.fest_no = i.fest_no) img ");
			buff.append("FROM  ");
			buff.append("    festival_review r, festival_img_file i ");
			buff.append("WHERE ");
			buff.append("    r.isshow = 'Y' ");
			buff.append("GROUP BY ");
			buff.append("    r.fest_no ");
			buff.append("ORDER BY ");
			buff.append("    DBMS_RANDOM.random() ");
			break;
		}
		return buff.toString();
	}
}
