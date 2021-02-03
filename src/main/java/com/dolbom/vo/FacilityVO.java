package com.dolbom.vo;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FacilityVO {
	private String fid, fname, fpname, fphone, fsido, fgugun, flocation, fsdate, fedate, fstime, fetime, fweek, fprogram, fimg, fsimg, savepath;
	private String fphone1, fphone2, fphone3;
	private String[] fweek_list;
	private int rno, fpeople, fcnt;
	private float fservice;
	CommonsMultipartFile file1, file2, file3, file4;
	

	public FacilityVO() {
		
	}
	
	public String getSavepath() {
		return savepath;
	}

	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}

	public CommonsMultipartFile getFile1() {
		return file1;
	}

	public void setFile1(CommonsMultipartFile file1) {
		this.file1 = file1;
	}
	
	public CommonsMultipartFile getFile2() {
		return file2;
	}

	public void setFile2(CommonsMultipartFile file2) {
		this.file2 = file2;
	}

	public CommonsMultipartFile getFile3() {
		return file3;
	}

	public void setFile3(CommonsMultipartFile file3) {
		this.file3 = file3;
	}

	public CommonsMultipartFile getFile4() {
		return file4;
	}

	public void setFile4(CommonsMultipartFile file4) {
		this.file4 = file4;
	}

	public String[] getFweek_list() {
		return fweek_list;
	}

	public void setFweek_list(String[] fweek_list) {
		this.fweek_list = fweek_list;
	}

	public String getFphone1() {
		return fphone1;
	}

	public void setFphone1(String fphone1) {
		this.fphone1 = fphone1;
	}

	public String getFphone2() {
		return fphone2;
	}

	public void setFphone2(String fphone2) {
		this.fphone2 = fphone2;
	}

	public String getFphone3() {
		return fphone3;
	}

	public void setFphone3(String fphone3) {
		this.fphone3 = fphone3;
	}

	public int getFcnt() {
		return fcnt;
	}

	public void setFcnt(int fcnt) {
		this.fcnt = fcnt;
	}

	public float getFservice() {
		return fservice;
	}

	public void setFservice(float fservice) {
		this.fservice = fservice;
	}

	public int getRno() {
		return rno;
	}
	
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getFsido() {
		return fsido;
	}
	
	public void setFsido(String fsido) {
		this.fsido = fsido;
	}
	
	public String getFgugun() {
		return fgugun;
	}
	
	public void setFgugun(String fgugun) {
		this.fgugun = fgugun;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFpname() {
		return fpname;
	}
	public void setFpname(String fpname) {
		this.fpname = fpname;
	}
	public String getFphone() {
		String str = "";
		
		if(fphone1 != null) {
			str = fphone1+"-"+fphone2+"-"+fphone3;
		} else {
			str = fphone;
		}
		
		return str;
	}
	public void setFphone(String fphone) {
		this.fphone = fphone;
	}
	public String getFlocation() {
		return flocation;
	}
	public void setFlocation(String flocation) {
		this.flocation = flocation;
	}
	public String getFsdate() {
		return fsdate;
	}
	public void setFsdate(String fsdate) {
		this.fsdate = fsdate;
	}
	public String getFedate() {
		return fedate;
	}
	public void setFedate(String fedate) {
		this.fedate = fedate;
	}
	public String getFstime() {
		return fstime;
	}
	public void setFstime(String fstime) {
		this.fstime = fstime;
	}
	public String getFetime() {
		return fetime;
	}
	public void setFetime(String fetime) {
		this.fetime = fetime;
	}
	public String getFweek() {
		String str = "";
		if(fweek_list != null) {
			str = String.join(",", fweek_list);
		}else {
			str = fweek;
		}
		return str;
	}
	public void setFweek(String fweek) {
		this.fweek = fweek;
	}
	public String getFprogram() {
		return fprogram;
	}
	public void setFprogram(String fprogram) {
		this.fprogram = fprogram;
	}
	public String getFimg() {
		return fimg;
	}
	public void setFimg(String fimg) {
		this.fimg = fimg;
	}
	public String getFsimg() {
		return fsimg;
	}
	public void setFsimg(String fsimg) {
		this.fsimg = fsimg;
	}
	public int getFpeople() {
		return fpeople;
	}
	public void setFpeople(int fpeople) {
		this.fpeople = fpeople;
	}
}
