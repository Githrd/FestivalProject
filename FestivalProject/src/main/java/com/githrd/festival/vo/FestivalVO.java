package com.githrd.festival.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FestivalVO {
// 이승연 VO
	private int fno, road, fee;
	private String fname, sdate, edate, content, place, host, ftel, href;
	private Date ss, ee;


	// 윤한기 VO
    private int ffee;
    private String foplace, fcontext, hostinst, hostorgan, fhaddr, froadaddr, latitude, longitude;
    private Date hsdate;
    private Date hedate;
    
    /*
    작성자 : 윤한기
    작성일 : 22-05-22
*/
//  축제정보에 사용하려고 추가한 부분
//------------------------------------------------------------
    private int rsco;
    private String idir;

    public int getRsco() {return rsco;}
    public void setRsco(int rsco) {this.rsco = rsco;}
    public String getIdir() {return idir;}
    public void setIdir(String idir) {this.idir = idir;}
//------------------------------------------------------------

	
// 윤한기 VO	
	public int getFfee() {
		return ffee;
	}
	public void setFfee(int ffee) {
		this.ffee = ffee;
	}
	public String getFoplace() {
		return foplace;
	}
	public void setFoplace(String foplace) {
		this.foplace = foplace;
	}
	public String getFcontext() {
		return fcontext;
	}
	public void setFcontext(String fcontext) {
		this.fcontext = fcontext;
	}
	public String getHostinst() {
		return hostinst;
	}
	public void setHostinst(String hostinst) {
		this.hostinst = hostinst;
	}
	public String getHostorgan() {
		return hostorgan;
	}
	public void setHostorgan(String hostorgan) {
		this.hostorgan = hostorgan;
	}
	public String getFhaddr() {
		return fhaddr;
	}
	public void setFhaddr(String fhaddr) {
		this.fhaddr = fhaddr;
	}
	public String getFroadaddr() {
		return froadaddr;
	}
	public void setFroadaddr(String froadaddr) {
		this.froadaddr = froadaddr;
	}
	public Date getHsdate() {
		return hsdate;
	}
	public void setHsdate(Date hsdate) {
		this.hsdate = hsdate;
	}
	public Date getHedate() {
		return hedate;
	}
	public void setHedate(Date hedate) {
		this.hedate = hedate;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	
// 이승연 VO
	public Date getSs() {
		return ss;
	}
	public void setSs(Date ss) {
		this.ss = ss;
	}
	public Date getEe() {
		return ee;
	}
	public void setEe(Date ee) {
		this.ee = ee;
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public int getRoad() {
		return road;
	}
	public void setRoad(int road) {
		this.road = road;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public void setSdate() {
		SimpleDateFormat form = new SimpleDateFormat("MM/dd");
		sdate = form.format(ss);
	}
	public void setSSdate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd");
		sdate = form.format(hsdate);
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public void setEdate() {
		SimpleDateFormat form = new SimpleDateFormat("MM/dd");
		edate = form.format(ee);
	}
	public void setEEdate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd");
		edate = form.format(hedate);
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getFtel() {
		return ftel;
	}
	public void setFtel(String ftel) {
		this.ftel = ftel;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	
	@Override
	public String toString() {
		return "FestivalVO [fno=" + fno + ", road=" + road + ", fee=" + fee + ", latitude=" + latitude + ", longitude="
				+ longitude + ", fname=" + fname + ", sdate=" + sdate + ", edate=" + edate + ", content=" + content
				+ ", place=" + place + ", host=" + host + ", ftel=" + ftel + ", href=" + href + "]";
	}
}
