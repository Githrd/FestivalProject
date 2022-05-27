/**
 *  축제 후기(Review) SQL 클래스이다.
 * @author	이승연
 * @since	2022/05/22
 * @version	v.1.0
 * 			작업이력 ]
 * 				2022.05.22	-	클래스제작
 * 								담당자 : 이승연
 *
 */
package com.githrd.festival.sql;

public class ReviewSQL {
	public final int SEL_MAIN_REVIEW	= 1001;
	public final int SEL_AVG_SCORE		= 1002;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_MAIN_REVIEW:
			buff.append("SELECT ");
			buff.append("    review_no, fname, review_title, review_body, review_wname, review_score ");
			buff.append("FROM ");
			buff.append("    festival_info , festival_review ");
			buff.append("WHERE ");
			buff.append("    fno = fest_no ");
			buff.append("    AND fno = ? ");
			buff.append("    AND ROWNUM <6 ");
			break;
		
		case SEL_AVG_SCORE:
			buff.append("SELECT ");
			buff.append("    ROUND(AVG(review_score), 1) score, fest_no ");
			//buff.append("    ,(SELECT fest_img_sname FROM festival_img_file i WHERE r.fest_no = i.fest_no) img ");
			buff.append("FROM ");
			buff.append("    festival_review ");
			buff.append("WHERE ");
			buff.append("    isshow = 'Y' ");
			buff.append("GROUP BY ");
			buff.append("    fest_no ");
			buff.append("ORDER BY ");
			buff.append("    DBMS_RANDOM.random() ");
			break;
		}
		return buff.toString();
	}
}
