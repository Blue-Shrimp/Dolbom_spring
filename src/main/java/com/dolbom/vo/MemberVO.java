package com.dolbom.vo;

import java.util.ArrayList;

public class MemberVO {
	private String did, dpass, dname, dphone, demail, darea, dchildren, ddate;
	private String cname, cyear, cmonth, cday, cgender;
	private String cname2, cyear2, cmonth2, cday2, cgender2;
	private String cname3, cyear3, cmonth3, cday3, cgender3;
	private String cname4, cyear4, cmonth4, cday4, cgender4;
	private String dphone1, dphone2, dphone3, demail1, demail3;
	
	public MemberVO() {
		
	}
	
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCyear() {
		return cyear;
	}

	public void setCyear(String cyear) {
		this.cyear = cyear;
	}

	public String getCmonth() {
		return cmonth;
	}

	public void setCmonth(String cmonth) {
		this.cmonth = cmonth;
	}

	public String getCday() {
		return cday;
	}

	public void setCday(String cday) {
		this.cday = cday;
	}

	public String getCgender() {
		return cgender;
	}

	public void setCgender(String cgender) {
		this.cgender = cgender;
	}
	
	public String getDphone1() {
		return dphone1;
	}

	public void setDphone1(String dphone1) {
		this.dphone1 = dphone1;
	}

	public String getDphone2() {
		return dphone2;
	}

	public void setDphone2(String dphone2) {
		this.dphone2 = dphone2;
	}

	public String getDphone3() {
		return dphone3;
	}

	public void setDphone3(String dphone3) {
		this.dphone3 = dphone3;
	}

	public String getDemail1() {
		return demail1;
	}

	public void setDemail1(String demail1) {
		this.demail1 = demail1;
	}

	public String getDemail3() {
		return demail3;
	}

	public String getCname2() {
		return cname2;
	}

	public void setCname2(String cname2) {
		this.cname2 = cname2;
	}

	public String getCyear2() {
		return cyear2;
	}

	public void setCyear2(String cyear2) {
		this.cyear2 = cyear2;
	}

	public String getCmonth2() {
		return cmonth2;
	}

	public void setCmonth2(String cmonth2) {
		this.cmonth2 = cmonth2;
	}

	public String getCday2() {
		return cday2;
	}

	public void setCday2(String cday2) {
		this.cday2 = cday2;
	}

	public String getCgender2() {
		return cgender2;
	}

	public void setCgender2(String cgender2) {
		this.cgender2 = cgender2;
	}

	public String getCname3() {
		return cname3;
	}

	public void setCname3(String cname3) {
		this.cname3 = cname3;
	}

	public String getCyear3() {
		return cyear3;
	}

	public void setCyear3(String cyear3) {
		this.cyear3 = cyear3;
	}

	public String getCmonth3() {
		return cmonth3;
	}

	public void setCmonth3(String cmonth3) {
		this.cmonth3 = cmonth3;
	}

	public String getCday3() {
		return cday3;
	}

	public void setCday3(String cday3) {
		this.cday3 = cday3;
	}

	public String getCgender3() {
		return cgender3;
	}

	public void setCgender3(String cgender3) {
		this.cgender3 = cgender3;
	}

	public String getCname4() {
		return cname4;
	}

	public void setCname4(String cname4) {
		this.cname4 = cname4;
	}

	public String getCyear4() {
		return cyear4;
	}

	public void setCyear4(String cyear4) {
		this.cyear4 = cyear4;
	}

	public String getCmonth4() {
		return cmonth4;
	}

	public void setCmonth4(String cmonth4) {
		this.cmonth4 = cmonth4;
	}

	public String getCday4() {
		return cday4;
	}

	public void setCday4(String cday4) {
		this.cday4 = cday4;
	}

	public String getCgender4() {
		return cgender4;
	}

	public void setCgender4(String cgender4) {
		this.cgender4 = cgender4;
	}

	public void setDemail3(String demail3) {
		this.demail3 = demail3;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getDpass() {
		return dpass;
	}

	public void setDpass(String dpass) {
		this.dpass = dpass;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDphone() {
		String str = "";
		
		if(dphone1 != null) {
			str = dphone1+"-"+dphone2+"-"+dphone3;
		} else {
			str = dphone;
		}
		
		return str;
	}

	public void setDphone(String dphone) {
		this.dphone = dphone;
	}

	public String getDemail() {
		return demail1 + "@" + demail3;
	}

	public void setDemail(String demail) {
		this.demail = demail;
	}

	public String getDarea() {
		return darea;
	}

	public void setDarea(String darea) {
		this.darea = darea;
	}

	public String getDchildren() {
		String result = "";

		String child1 = cname + "/" + cyear + "." + cmonth + "." + cday + "/" + cgender;
		String child2 = cname2 + "/" + cyear2 + "." + cmonth2 + "." + cday2 + "/" + cgender2;
		String child3 = cname3 + "/" + cyear3 + "." + cmonth3 + "." + cday3 + "/" + cgender3;
		String child4 = cname4 + "/" + cyear4 + "." + cmonth4 + "." + cday4 + "/" + cgender4;
		
		if(cgender != null) {
			if(cgender2 == null) {
				result = child1;
			} else if(cgender3 == null) {
				result = child1 + "," + child2;
			} else if(cgender4 == null) {
				result = child1 + "," + child2 + "," + child3;
			} else {
				result = child1 + "," + child2 + "," + child3 + "," + child4;
			}
			 
		} else {
			result = dchildren;
		}
		
		
		return result;
	}

	public void setDchildren(String dchildren) {
		this.dchildren = dchildren;
	}

	public String getDdate() {
		return ddate;
	}

	public void setDdate(String ddate) {
		this.ddate = ddate;
	}
	
	
}
