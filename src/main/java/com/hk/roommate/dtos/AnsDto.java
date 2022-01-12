package com.hk.roommate.dtos;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AnsDto {
	

    private int rm_seq;
    private String rm_id;
    private String rm_location;
    private String rm_mf;
    private String rm_c;
    private String rm_title;
    private String rm_content;
    private int rm_refer;
    private int rm_step;
    private int rm_depth;
    private int rm_cost1;
    private int rm_cost2;
    private int rm_cost3;
    private int rm_cost4;
    private int rm_readcount;
    private Date rm_date;
	
	public AnsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	  public AnsDto(String rm_id, String rm_title, String rm_content)
	    {
	        this.rm_id = rm_id;
	        this.rm_title = rm_title;
	        this.rm_content = rm_content;
	    }
	  
	  public AnsDto(String rm_id, String rm_location, String rm_mf, String rm_c, String rm_title, String rm_content, int rm_cost1, 
	            int rm_cost2, int rm_cost3, int rm_cost4)
	    {
	        this.rm_id = rm_id;
	        this.rm_location = rm_location;
	        this.rm_mf = rm_mf;
	        this.rm_c = rm_c;
	        this.rm_title = rm_title;
	        this.rm_content = rm_content;
	        this.rm_cost1 = rm_cost1;
	        this.rm_cost2 = rm_cost2;
	        this.rm_cost3 = rm_cost3;
	        this.rm_cost4 = rm_cost4;
	    }
	  
	  public AnsDto(int rm_seq, String rm_id, String rm_location, String rm_mf, String rm_c, String rm_title, String rm_content, 
	            int rm_cost1, int rm_cost2, int rm_cost3, int rm_cost4, int rm_readcount, Date rm_date, int rm_refer, 
	            int rm_step, int rm_depth)
	    {
	        this.rm_seq = rm_seq;
	        this.rm_id = rm_id;
	        this.rm_location = rm_location;
	        this.rm_mf = rm_mf;
	        this.rm_c = rm_c;
	        this.rm_title = rm_title;
	        this.rm_content = rm_content;
	        this.rm_refer = rm_refer;
	        this.rm_step = rm_step;
	        this.rm_depth = rm_depth;
	        this.rm_cost1 = rm_cost1;
	        this.rm_cost2 = rm_cost2;
	        this.rm_cost3 = rm_cost3;
	        this.rm_cost4 = rm_cost4;
	        this.rm_readcount = rm_readcount;
	        this.rm_date = rm_date;
	    }
	  
	  

	public int getRm_seq() {
		return rm_seq;
	}

	public void setRm_seq(int rm_seq) {
		this.rm_seq = rm_seq;
	}

	public String getRm_id() {
		return rm_id;
	}

	public void setRm_id(String rm_id) {
		this.rm_id = rm_id;
	}

	public String getRm_location() {
		return rm_location;
	}

	public void setRm_location(String rm_location) {
		this.rm_location = rm_location;
	}

	public String getRm_mf() {
		return rm_mf;
	}

	public void setRm_mf(String rm_mf) {
		this.rm_mf = rm_mf;
	}

	public String getRm_c() {
		return rm_c;
	}

	public void setRm_c(String rm_c) {
		this.rm_c = rm_c;
	}

	public String getRm_title() {
		return rm_title;
	}

	public void setRm_title(String rm_title) {
		this.rm_title = rm_title;
	}

	public String getRm_content() {
		return rm_content;
	}

	public void setRm_content(String rm_content) {
		this.rm_content = rm_content;
	}

	public int getRm_refer() {
		return rm_refer;
	}

	public void setRm_refer(int rm_refer) {
		this.rm_refer = rm_refer;
	}

	public int getRm_step() {
		return rm_step;
	}

	public void setRm_step(int rm_step) {
		this.rm_step = rm_step;
	}

	public int getRm_depth() {
		return rm_depth;
	}

	public void setRm_depth(int rm_depth) {
		this.rm_depth = rm_depth;
	}

	public int getRm_cost1() {
		return rm_cost1;
	}

	public void setRm_cost1(int rm_cost1) {
		this.rm_cost1 = rm_cost1;
	}

	public int getRm_cost2() {
		return rm_cost2;
	}

	public void setRm_cost2(int rm_cost2) {
		this.rm_cost2 = rm_cost2;
	}

	public int getRm_cost3() {
		return rm_cost3;
	}

	public void setRm_cost3(int rm_cost3) {
		this.rm_cost3 = rm_cost3;
	}

	public int getRm_cost4() {
		return rm_cost4;
	}

	public void setRm_cost4(int rm_cost4) {
		this.rm_cost4 = rm_cost4;
	}

	public int getRm_readcount() {
		return rm_readcount;
	}

	public void setRm_readcount(int rm_readcount) {
		this.rm_readcount = rm_readcount;
	}

	public Date getRm_date() {
		return rm_date;
	}

	public void setRm_date(Date rm_date) {
		this.rm_date = rm_date;
	}

	@Override
	public String toString() {
		return "AnsDto [rm_seq=" + rm_seq + ", rm_id=" + rm_id + ", rm_location=" + rm_location + ", rm_mf=" + rm_mf
				+ ", rm_c=" + rm_c + ", rm_title=" + rm_title + ", rm_content=" + rm_content + ", rm_refer=" + rm_refer
				+ ", rm_step=" + rm_step + ", rm_depth=" + rm_depth + ", rm_cost1=" + rm_cost1 + ", rm_cost2="
				+ rm_cost2 + ", rm_cost3=" + rm_cost3 + ", rm_cost4=" + rm_cost4 + ", rm_readcount=" + rm_readcount
				+ ", rm_date=" + rm_date + "]";
	}  

	
	
}
