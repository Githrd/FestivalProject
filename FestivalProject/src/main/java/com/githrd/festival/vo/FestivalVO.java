package com.githrd.festival.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FestivalVO {
	private int fno, road, fee, latitude, longitude;
	private String fname, sdate, edate, content, place, host, ftel, href;
	private Date ss, ee;
	
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
	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
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
