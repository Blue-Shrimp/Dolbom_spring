package com.dolbom.vo;

public class ReviewVO {
	private String rid, fid, did, rcontent, rdate, dname, fpname;
	private int rservice, rstatus, rno;
	
	public ReviewVO() {
		
	}
	
	public String getFpname() {
		return fpname;
	}

	public void setFpname(String fpname) {
		this.fpname = fpname;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public int getRservice() {
		return rservice;
	}
	public void setRservice(int rservice) {
		this.rservice = rservice;
	}
	public int getRstatus() {
		return rstatus;
	}
	public void setRstatus(int rstatus) {
		this.rstatus = rstatus;
	} 
}
