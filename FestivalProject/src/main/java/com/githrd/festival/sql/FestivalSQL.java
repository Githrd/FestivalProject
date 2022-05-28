/**
 *  축제 정보(festival_info) SQL 클래스이다.
 * @author	이승연
 * @since	2022/05/22
 * @version	v.1.0
 * 			작업이력 ]
 * 				2022.05.22	-	클래스제작
 * 								담당자 : 이승연
 *
 */
package com.githrd.festival.sql;

public class FestivalSQL {
	public final int SEL_MAIN_INFO	= 1001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_MAIN_INFO:
			buff.append("SELECT   fno, fname, open_place, sdate, edate, ");
			buff.append("    TO_DATE(sdate, 'YY/MM/DD') - TO_DATE(sysdate, 'YY/MM/DD') diff ");
			buff.append("FROM ( ");
			buff.append("    SELECT ");
			buff.append("        fno, fname, open_place, sdate, edate, ");
			buff.append("        TO_DATE(sdate, 'YY/MM/DD') - TO_DATE(sysdate, 'YY/MM/DD') diff ");
			buff.append("    FROM ");
			buff.append("        festival_info ");
			buff.append("    WHERE ");
			buff.append("        TO_DATE(sdate, 'YY/MM/DD') - TO_DATE(sysdate, 'YY/MM/DD') > 0 ");
			buff.append("		 AND isshow = 'Y' ");
			buff.append("    order by ");
			buff.append("        diff asc ");
			buff.append("    ) ");
			buff.append("WHERE rownum < 7 ");

			break;
		}
		return buff.toString();
	}
}
