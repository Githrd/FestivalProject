package com.githrd.festival.sql;
/*
    Created by HG on 2022-05-26
    
*/

public class FinfoSQL {
    public final int SCH_FEST_INFO = 1001;
    public final int CAL_FEST_CNT = 1002;
    public final int SEL_FEST_DETAIL = 1003;

    public String getSQL(int code) {
        StringBuffer buff = new StringBuffer();

        switch (code) {
            case SCH_FEST_INFO:
                buff.append("SELECT ");
                buff.append("   FNO, FNAME, FCONTEXT, i.FEST_IMG_SDIR, SDATE, EDATE, r.REVIEW_SCORE ");
                buff.append("FROM ");
                buff.append("   FESTIVAL_INFO, FESTIVAL_IMG_FILE i, FESTIVAL_REVIEW r ");
                buff.append("WHERE ");
                buff.append("   FNO = i.FEST_NO(+) ");
                buff.append("   AND FNO = r.FEST_NO(+) ");
                buff.append("   AND FNO between ? and ? ");
                break;
            case CAL_FEST_CNT:
                buff.append("SELECT ");
                buff.append("    COUNT(*) cnt ");
                buff.append("FROM ");
                buff.append("    FESTIVAL_INFO ");
                break;
            case SEL_FEST_DETAIL:
                buff.append("SELECT ");
                buff.append("    FNAME, FCONTEXT, OPEN_PLACE, SDATE, EDATE, FTEL, FHADDR, ROAD_ADDR, FEST_IMG_SDIR ");
                buff.append("FROM ");
                buff.append("    FESTIVAL_INFO, FESTIVAL_IMG_FILE ");
                buff.append("WHERE ");
                buff.append("    FNO = FEST_NO(+) ");
                buff.append("    AND FNO = ? ");
                break;
        }
        return buff.toString();
    }
}
