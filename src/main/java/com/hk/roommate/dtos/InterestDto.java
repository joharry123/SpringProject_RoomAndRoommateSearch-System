package com.hk.roommate.dtos;

public class InterestDto {
	

    private int i_seq;
    private String i_id;
    private int i_roomseq;
    private String i_delflag;
    
    public InterestDto() {
  		super();
  		// TODO Auto-generated constructor stub
  	}
    
    public InterestDto(int i_seq, String i_id, int i_roomseq, String i_delflag)
    {
        this.i_seq = i_seq;
        this.i_id = i_id;
        this.i_roomseq = i_roomseq;
        this.i_delflag = i_delflag;
    }
    
    public InterestDto(String i_id, int i_roomseq)
    {
        this.i_id = i_id;
        this.i_roomseq = i_roomseq;
    }
  

	public int getI_seq() {
		return i_seq;
	}

	public void setI_seq(int i_seq) {
		this.i_seq = i_seq;
	}

	public String getI_id() {
		return i_id;
	}

	public void setI_id(String i_id) {
		this.i_id = i_id;
	}

	public int getI_roomseq() {
		return i_roomseq;
	}

	public void setI_roomseq(int i_roomseq) {
		this.i_roomseq = i_roomseq;
	}

	public String getI_delflag() {
		return i_delflag;
	}

	public void setI_delflag(String i_delflag) {
		this.i_delflag = i_delflag;
	}

	@Override
	public String toString() {
		return "InterestDto [i_seq=" + i_seq + ", i_id=" + i_id + ", i_roomseq=" + i_roomseq + ", i_delflag="
				+ i_delflag + "]";
	}
  
}
