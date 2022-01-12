package com.hk.roommate.dtos;
import java.util.Date;
public class filedto {  
	
	
	private int f_seq;
	private String file_name;
	private String stored_fname;
    private int file_size;
    private Date file_Date;
    private String f_delflag;
    
    
    public filedto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public filedto(int f_seq, String file_name, String stored_fname, int file_size, Date file_Date, String f_delflag) {
		super();
		this.f_seq = f_seq;
		this.file_name = file_name;
		this.stored_fname = stored_fname;
		this.file_size = file_size;
		this.file_Date = file_Date;
		this.f_delflag = f_delflag;
	}
	
	public filedto(int f_seq) {
		super();
		this.f_seq = f_seq;  
	}
	
	public int getF_seq() {
		return f_seq;
	}
	public void setF_seq(int f_seq) {
		this.f_seq = f_seq;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getStored_fname() {
		return stored_fname;
	}
	public void setStored_fname(String stored_fname) {
		this.stored_fname = stored_fname;
	}
	public int getFile_size() {
		return file_size;
	}
	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}
	public Date getFile_Date() {
		return file_Date;
	}
	public void setFile_Date(Date file_Date) {
		this.file_Date = file_Date;
	}
	public String getF_delflag() {
		return f_delflag;
	}
	public void setF_delflag(String f_delflag) {
		this.f_delflag = f_delflag;
	}
	@Override
	public String toString() {
		return "filedto [f_seq=" + f_seq + ", file_name=" + file_name + ", stored_fname=" + stored_fname
				+ ", file_size=" + file_size + ", file_Date=" + file_Date + ", f_delflag=" + f_delflag + "]";
	}


}
