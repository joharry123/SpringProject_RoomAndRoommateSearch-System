package com.hk.roommate.service;
import com.hk.roommate.dtos.AnsDto;
import java.util.List;

public interface IAnsService {

	 	public  List<AnsDto> getAllList();

	    public  boolean insertBoard(AnsDto ansdto);

	    public  boolean updateBoard(AnsDto ansdto);

	    public  boolean deleteBoard(String seqs[]);

	    public  boolean readCount(int i);

	    public  boolean replyBoard(AnsDto ansdto);

	    public  AnsDto getAnsBoard(int rm_seq);
}
